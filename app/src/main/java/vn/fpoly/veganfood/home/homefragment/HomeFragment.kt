package vn.fpoly.veganfood.home.homefragment

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import vn.fpoly.veganfood.R
import vn.fpoly.veganfood.basekotlin.base.BaseFragment
import vn.fpoly.veganfood.basekotlin.base.BaseViewModel
import vn.fpoly.veganfood.basekotlin.extensions.viewBinding
import vn.fpoly.veganfood.databinding.FragmentHomeBinding
import vn.fpoly.veganfood.dialog.DialogUtils
import vn.fpoly.veganfood.feature.account.activity.AccountActivity
import vn.fpoly.veganfood.home.homefragment.ViewPagerAdapter
import vn.fpoly.veganfood.home.homefragment.productfragment.SlideBannerAdapter
import vn.fpoly.veganfood.home.search.SearchActivity
import vn.fpoly.veganfood.model.CategoriesResult
import vn.fpoly.veganfood.model.UserInfoResult
import vn.fpoly.veganfood.network.NetWorkController
import vn.fpoly.veganfood.network.TCCCallback
import vn.fpoly.veganfood.util.NetworkUtils
import com.google.android.gms.location.LocationServices
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import java.util.*

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    override val binding by viewBinding<FragmentHomeBinding>()

    override val viewModel: BaseViewModel
        get() = TODO("Not yet implemented")

    private var firstPagePosition = 0

    private val sharedPref by lazy {
        requireContext().getSharedPreferences(
            requireContext().getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )
    }

    private val editor by lazy {
        sharedPref.edit()
    }

    private val listPhoto = listOf(
        R.drawable.banner_2,
        R.drawable.ic_item_home,
        R.drawable.banner_3,
        R.drawable.banner_4,
        R.drawable.banner_5
    )
    private val slideAdapter by lazy {
        SlideBannerAdapter(listPhoto)
    }

    private var timber: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setupViews() {
        requestPermissionLocation()
        setSlideBanner()
        autoSlideImage()
    }

    override fun onResume() {
        super.onResume()
        getUserInfo()
        getLocation()
        setupClickListener()
        getCategoryList()
        binding.linearLayoutCompat.setOnClickListener {
            startActivity(Intent(requireContext(), SearchActivity::class.java))
        }
        binding.tvSearch.setOnClickListener {
            startActivity(Intent(requireContext(), SearchActivity::class.java))
        }
    }

    private fun setSlideBanner() = binding.run {
        viewPagerSlide.adapter = slideAdapter
        indicator.setViewPager(viewPagerSlide)
        slideAdapter.registerDataSetObserver(indicator.dataSetObserver)
    }

    private fun autoSlideImage() = binding.run {
        if (timber == null) {
            timber = Timer()
        }

        timber!!.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post {
                    var currentItem = viewPagerSlide.currentItem
                    val totalItem = listPhoto.size - 1
                    if (currentItem < totalItem) {
                        currentItem++
                        viewPagerSlide.currentItem = currentItem
                    } else {
                        viewPagerSlide.currentItem = 0
                    }
                }
            }

        }, 500, 3000)
    }

    private var viewPagerAdapter: ViewPagerAdapter? = null

    private fun getCategoryList() {
        DialogUtils.showProgressDialog(requireActivity())
        if (NetworkUtils.isConnect(requireActivity())) {
            NetWorkController.getListCategories(object : TCCCallback<CategoriesResult>() {
                override fun onTCTCSuccess(
                    call: Call<CategoriesResult>?,
                    response: Response<CategoriesResult>?
                ) {
                    setupTabLayoutWithViewPager(response?.body()?.result)
                    DialogUtils.dismissProgressDialog()
                    binding.root.isVisible = true
                }

                override fun onTCTCFailure(call: Call<CategoriesResult>?) {
                    Timber.tag(call.toString())
                    DialogUtils.dismissProgressDialog()
                }

            })
        }
    }

    private fun setupClickListener() = binding.run {
        imgAccount.setOnClickListener {
            startActivity(Intent(requireActivity(), AccountActivity::class.java))
        }
        imgName.setOnClickListener {
            startActivity(Intent(requireActivity(), AccountActivity::class.java))
        }
    }

    private fun getUserInfo() = binding.run {
        val token =
            sharedPref?.getString(requireContext().getString(R.string.preference_key_token), "")
        if (NetworkUtils.isConnect(requireActivity())) {
            NetWorkController.getUserInfo(object : TCCCallback<UserInfoResult>() {
                override fun onTCTCSuccess(
                    call: Call<UserInfoResult>?,
                    response: Response<UserInfoResult>?
                ) {
                    if (response?.body()?.results?.name != null) {
                        imgAccount.isVisible = false
                        imgName.text = response.body()!!.results.name.substring(0, 1)
                            .uppercase(Locale.getDefault())
                        imgName.isVisible = true
                    } else {
                        imgAccount.isVisible = true
                        imgName.isVisible = false
                    }
                }

                override fun onTCTCFailure(call: Call<UserInfoResult>?) {
                    imgAccount.isVisible = true
                    imgName.isVisible = false
                }

            }, token)
        }
    }

    private fun setupTabLayoutWithViewPager(list: List<CategoriesResult.CategoriesResultModel>?) {
        list?.let {
            binding.tabLayout.setData(list.map { it.name })
            viewPagerAdapter = ViewPagerAdapter(this, list)
            viewPagerAdapter?.let {
                if (list.isNotEmpty()) {
                    binding.viewPager.offscreenPageLimit = list.size
                }
                binding.viewPager.adapter = it
            }
            binding.tabLayout.post {
                if (isAdded) {
                    if (firstPagePosition == 0) {
                        binding.tabLayout.onPagerSelectedAt(firstPagePosition)
                        binding.viewPager.currentItem = firstPagePosition
                    } else {
                        binding.tabLayout.onPagerSelectedAt(binding.viewPager.currentItem)
                    }
                    binding.tabLayout.addTabSelectedListener {
                        binding.viewPager.setCurrentItem(it, false)
                    }
                }
            }
            val callback = object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    binding.tabLayout.onPagerSelectedAt(position)
                }

                override fun onPageSelected(position: Int) {
                    binding.tabLayout.onPagerSelectedAt(position)
                    firstPagePosition = position
                }
            }
            binding.viewPager.registerOnPageChangeCallback(callback)
            binding.viewPager.isVisible = true
            binding.tabLayout.isVisible = true
        } ?: kotlin.run {
        }
    }


    private fun getLocation() = binding.run {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLocation()
            return@run
        } else {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    if (activity != null) {
                        val geocoder = Geocoder(requireActivity(), Locale.getDefault())
                        if (location != null) {
                            val address = geocoder.getFromLocation(
                                location.latitude,
                                location.longitude,
                                1
                            )[0].getAddressLine(0)
                            binding.tvLocation.text = address
                            editor.putString(requireContext().getString(R.string.address), address)
                            editor.apply()
                        }
                    }
                }
        }
    }

    private fun requestPermissionLocation() = binding.run {

        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    Timber.tag("setupViews ACCESS_FINE_LOCATION: ")
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    Timber.tag("setupViews ACCESS_COARSE_LOCATION: ")
                }
                else -> {
                    Timber.tag("setupViews no location: ")
                }
            }
        }
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    override fun bindViewModel() {
        //No TODO here
    }

    override fun onDestroy() {
        super.onDestroy()
        if (timber != null) {
            timber!!.cancel()
            timber = null
        }
    }

}