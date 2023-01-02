package vn.fpoly.veganfood.home.activityhome

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import vn.fpoly.veganfood.basekotlin.base.BaseActivity
import vn.fpoly.veganfood.basekotlin.base.BaseViewModel
import vn.fpoly.veganfood.basekotlin.extensions.viewBinding
import vn.fpoly.veganfood.databinding.ActivityHomeBinding
import vn.fpoly.veganfood.dialog.DialogUtils
import vn.fpoly.veganfood.feature.order.OrderActivity
import vn.fpoly.veganfood.feature.orderStatus.OrderStatusActivity
import vn.fpoly.veganfood.home.favoritefragment.FavoriteFragment
import vn.fpoly.veganfood.home.homefragment.HomeFragment
import vn.fpoly.veganfood.home.notificationfragment.NotificationFragment
import vn.fpoly.veganfood.home.orderfragment.OrderListFragment
import vn.fpoly.veganfood.model.CartInfoResult
import vn.fpoly.veganfood.model.SessionIdResult
import vn.fpoly.veganfood.model.UserCurrentResult
import vn.fpoly.veganfood.network.NetWorkController
import vn.fpoly.veganfood.network.TCCCallback
import vn.fpoly.veganfood.util.NetworkUtils
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import vn.fpoly.veganfood.R

class HomeActivity : BaseActivity(R.layout.activity_home) {
    override val binding by viewBinding<ActivityHomeBinding>()
    override val viewModel: BaseViewModel
        get() = TODO("Not yet implemented")
    private var receiver: MyBroadcastReceiver? = null
    private val sharedPref by lazy {
        getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )
    }

    private val token by lazy {
        sharedPref?.getString(getString(R.string.preference_key_token), "")
    }

    private val sessionId by lazy {
        sharedPref.getInt(getString(R.string.session_id), 0)
    }
    private val editor by lazy {
        sharedPref.edit()
    }


    override fun setupViews() {
        setupBottomNav()
        getIntentId()
        getOrderIcon()

        receiver = MyBroadcastReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.my.app.onMessageReceived")
        registerReceiver(receiver, intentFilter)
    }

    override fun onResume() {
        super.onResume()

        getCartList()
        getOrderIcon()
        val token =
            sharedPref?.getString(getString(R.string.preference_key_token), "")
        binding.imgCart.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("tokenToOrder", token)
            startActivity(intent)
        }
    }




    private fun getCartList() = binding.run {
        DialogUtils.showProgressDialog(this@HomeActivity)
        var secId = 0;
        val token =
            sharedPref?.getString(getString(R.string.preference_key_token), "")
        if (NetworkUtils.isConnect(this@HomeActivity)) {
            NetWorkController.getUserShoppingSession(object : TCCCallback<SessionIdResult>() {
                override fun onTCTCSuccess(
                    call: Call<SessionIdResult>?,
                    response: Response<SessionIdResult>?
                ) {
                    if(response?.body()?.isSuccess == true) {
                        secId = response.body()?.result?.id!!
                        NetWorkController.getCartInfo(
                            object : TCCCallback<CartInfoResult>() {
                                override fun onTCTCSuccess(
                                    call: Call<CartInfoResult>?,
                                    response: Response<CartInfoResult>?
                                ) {
                                    val itemCart = response?.body()?.results?.totalCategory
                                    frameLayout.isVisible = !itemCart.equals("0", true) && itemCart != null
                                    imgCart.isVisible = !itemCart.equals("0", true)
                                    tvNumber.text = itemCart
                                    DialogUtils.dismissProgressDialog()
                                }

                                override fun onTCTCFailure(call: Call<CartInfoResult>?) {
                                    Timber.tag(call.toString())
                                    DialogUtils.dismissProgressDialog()
                                }
                            }, token, secId
                        )
                    }else {
                        NetWorkController.getCartInfo(
                            object : TCCCallback<CartInfoResult>() {
                                override fun onTCTCSuccess(
                                    call: Call<CartInfoResult>?,
                                    response: Response<CartInfoResult>?
                                ) {
                                    val itemCart = response?.body()?.results?.totalCategory
                                    frameLayout.isVisible = !itemCart.equals("0", true) && itemCart != null
                                    imgCart.isVisible = !itemCart.equals("0", true)
                                    tvNumber.text = itemCart
                                    DialogUtils.dismissProgressDialog()
                                }

                                override fun onTCTCFailure(call: Call<CartInfoResult>?) {
                                    Timber.tag(call.toString())
                                    DialogUtils.dismissProgressDialog()
                                }
                            }, token, sessionId
                        )
                    }

                }

                override fun onTCTCFailure(call: Call<SessionIdResult>?) {
                }
            }, token)

        }
    }

    inner class MyBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val extras = intent.extras
            val state = extras!!.getString("extra")
            if(state.equals("Đơn hàng của bạn đã được xác nhận")) {
                editor.putInt("shipping",
                    1
                )
                editor.apply()
            }else if(state.equals("Đơn hàng của bạn đã giao xong")){
                editor.putInt("shipping",
                    2
                )
                editor.apply()
            }
            getOrderIcon()
        }
    }
     private fun getOrderIcon() = binding.run {
        DialogUtils.showProgressDialog(this@HomeActivity)
         val token =
             sharedPref?.getString(getString(R.string.preference_key_token), "")
        if (NetworkUtils.isConnect(this@HomeActivity)) {
            NetWorkController.getUserCurrentOrder(
                object : TCCCallback<UserCurrentResult>() {
                    override fun onTCTCSuccess(
                        call: Call<UserCurrentResult>?,
                        response: Response<UserCurrentResult>?
                    ) {
                        if (response != null) {
                            if(response?.body()?.isSuccess == true) {
                                frameLayout2?.isVisible = response.isSuccessful
                                frameLayout2?.setOnClickListener {
                                    val intent =
                                        Intent(this@HomeActivity, OrderStatusActivity::class.java)
                                    response.body()?.results.apply {
                                        intent.putExtra("orderId", this?.orderId)
                                        intent.putExtra("total", this?.total)
                                        intent.putExtra("paymentId", this?.paymentId)
                                        intent.putExtra("status", this?.status)
                                        intent.putExtra("provider", this?.provider)
                                        intent.putExtra("address", this?.address)
                                        intent.putExtra("phoneNumber", this?.phoneNumber)
                                    }
                                    startActivity(intent)
                                }
                            }else {
                                frameLayout2?.isVisible = false;
                            }

                        }
                        DialogUtils.dismissProgressDialog()
                    }

                    override fun onTCTCFailure(call: Call<UserCurrentResult>?) {
                        Timber.tag(call.toString())
                        DialogUtils.dismissProgressDialog()
                    }
                }, token
            )
        }
    }

    private fun getIntentId() = binding.run {
        val intent = intent
        intent?.let {
            if (it.getBooleanExtra("goToFavorite", false)) {
                bottomNav.selectedItemId = R.id.favorite
            } else if (it.getBooleanExtra("goToOrder", false)) {
                bottomNav.selectedItemId = R.id.cart
            } else {
                replaceFragment(HomeFragment())
            }
        }

    }

    private fun setupBottomNav() = binding.run {
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.favorite -> replaceFragment(FavoriteFragment())
                R.id.cart -> replaceFragment(OrderListFragment())
                R.id.notification -> replaceFragment(NotificationFragment())
                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) = binding.run {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }


    override fun bindViewModel() {
        //No TODO here
    }

}