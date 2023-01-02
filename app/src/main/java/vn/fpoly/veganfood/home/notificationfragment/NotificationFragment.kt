package vn.fpoly.veganfood.home.notificationfragment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.core.view.isVisible
import vn.fpoly.veganfood.R
import vn.fpoly.veganfood.basekotlin.base.BaseFragment
import vn.fpoly.veganfood.basekotlin.base.BaseViewModel
import vn.fpoly.veganfood.basekotlin.extensions.viewBinding
import vn.fpoly.veganfood.databinding.FragmentNotificationBinding
import vn.fpoly.veganfood.dialog.DialogUtils
import vn.fpoly.veganfood.feature.notifi.NotifiActivity
import vn.fpoly.veganfood.model.NotifiResult
import vn.fpoly.veganfood.network.NetWorkController
import vn.fpoly.veganfood.network.TCCCallback
import vn.fpoly.veganfood.util.NetworkUtils
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber

class NotificationFragment : BaseFragment(R.layout.fragment_notification){
    override val binding: FragmentNotificationBinding by viewBinding()

    private val promoteAdapter by lazy(LazyThreadSafetyMode.NONE) {
        NotificationAdapter(onItemClick = {
            val intent = Intent(requireActivity(), NotifiActivity::class.java)
            intent.putExtra("titleNotifi", it.title)
            intent.putExtra("contentNotifi", it.message)
            intent.putExtra("imageNotifi", it.image)
            startActivity(intent)
        })
    }

    private val newsAdapter by lazy(LazyThreadSafetyMode.NONE) {
        NotificationAdapter(onItemClick = {
            val intent = Intent(requireActivity(), NotifiActivity::class.java)
            intent.putExtra("titleNotifi", it.title)
            intent.putExtra("contentNotifi", it.message)
            intent.putExtra("imageNotifi", it.image)
            startActivity(intent)
        })
    }

    override val viewModel: BaseViewModel
        get() = TODO("Not yet implemented")

    override fun setupViews() {
        setupRecyclerView()
        getListNotification()
    }


    private fun getListNotification() {
        DialogUtils.showProgressDialog(requireActivity())
        if (NetworkUtils.isConnect(requireActivity())) {
            NetWorkController.getPromoteNotifications(object :
                TCCCallback<NotifiResult>() {
                @SuppressLint("SetTextI18n")
                override fun onTCTCSuccess(
                    call: Call<NotifiResult>?,
                    response: Response<NotifiResult>?
                ) {
                    if (response?.body()?.result != null) {
                        promoteAdapter.submitList(response.body()?.result)
                    }
                }

                override fun onTCTCFailure(call: Call<NotifiResult>?) {
                    Timber.tag(call.toString())
                    DialogUtils.dismissProgressDialog()
                }
            })
            NetWorkController.getNewsNotifications(object :
                TCCCallback<NotifiResult>() {
                @SuppressLint("SetTextI18n")
                override fun onTCTCSuccess(
                    call: Call<NotifiResult>?,
                    response: Response<NotifiResult>?
                ) {
                    if (response?.body()?.result != null) {
                        newsAdapter.submitList(response.body()?.result)
                    }

                }

                override fun onTCTCFailure(call: Call<NotifiResult>?) {
                    Timber.tag(call.toString())
                    DialogUtils.dismissProgressDialog()
                }
            })
            DialogUtils.dismissProgressDialog()
            binding.root.isVisible = true
        }
    }


    private fun setupRecyclerView() = binding.run {
        rvKhuyenMai.adapter = promoteAdapter
        rvTintuc.adapter = newsAdapter
    }

    override fun bindViewModel() {
        //No TODO here
    }

}