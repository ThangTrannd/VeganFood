package vn.fpoly.veganfood.home.orderfragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.core.view.isVisible
import vn.fpoly.veganfood.R
import vn.fpoly.veganfood.basekotlin.base.BaseFragment
import vn.fpoly.veganfood.basekotlin.base.BaseViewModel
import vn.fpoly.veganfood.basekotlin.extensions.viewBinding
import vn.fpoly.veganfood.databinding.FragmentOrderListBinding
import vn.fpoly.veganfood.dialog.DialogUtils
import vn.fpoly.veganfood.feature.login.LoginActivity
import vn.fpoly.veganfood.home.orderdetail.ActivityOrderDetail
import vn.fpoly.veganfood.model.UserOrderResult
import vn.fpoly.veganfood.network.NetWorkController
import vn.fpoly.veganfood.network.TCCCallback
import vn.fpoly.veganfood.util.NetworkUtils
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber

class OrderListFragment : BaseFragment(R.layout.fragment_order_list) {
    override val binding: FragmentOrderListBinding by viewBinding()

    override val viewModel: BaseViewModel
        get() = TODO("Not yet implemented")

    private val sharedPref by lazy {
        requireContext().getSharedPreferences(
            requireContext().getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )
    }

    private val listOrderAdapter by lazy(LazyThreadSafetyMode.NONE) {
        OrderListAdapter(onItemClick = {
            val intent = Intent(requireActivity(), ActivityOrderDetail::class.java)
            intent.putExtra("idProduct", it)
            startActivity(intent)
        })
    }

    override fun setupViews() {
        setupRecyclerView()
        getOrderList()
        setupListener()
    }

    private fun setupListener() = binding.run {
        btnLogin.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.putExtra("fromFavorite", true)
            startActivity(intent)
        }
    }

    private fun getOrderList() = binding.run {
        binding.root.isVisible = false
        val keyToken =
            sharedPref?.getString(requireContext().getString(R.string.preference_key_token), "")
        if (keyToken.isNullOrEmpty()) {
            layoutProduct.isVisible = false
            layoutNullProduct.isVisible = true
            btnLogin.isVisible = true
            tvDesc.text = getString(R.string.fragment_favorite_null_account)
            binding.root.isVisible = true
        } else {

            DialogUtils.showProgressDialog(requireActivity())
            if (NetworkUtils.isConnect(requireActivity())) {
                NetWorkController.getUserOrder(object :
                    TCCCallback<UserOrderResult>() {
                    @SuppressLint("SetTextI18n")
                    override fun onTCTCSuccess(
                        call: Call<UserOrderResult>?,
                        response: Response<UserOrderResult>?
                    ) {
                        if (!response?.body()?.results.isNullOrEmpty()) {
                            println("Thắng $response")
                            println("Thắng ${response?.body()?.results} ${response?.body()?.isSuccess}")
                            listOrderAdapter.submitList(response?.body()?.results)
                            layoutNullProduct.isVisible = false
                            layoutProduct.isVisible = true
                        } else {
                            layoutProduct.isVisible = false
                            layoutNullProduct.isVisible = true
                            tvDesc.text = "Không có sản phẩm nào trong giỏ hàng"
                            btnLogin.isVisible = false
                        }
                        DialogUtils.dismissProgressDialog()
                        binding.root.isVisible = true
                    }

                    override fun onTCTCFailure(call: Call<UserOrderResult>?) {
                        Timber.tag(call.toString())
                        DialogUtils.dismissProgressDialog()
                    }
                }, keyToken)
                //eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTIsInVzZXJuYW1lIjoiZGlldW5uMjAxMiIsInBhc3N3b3JkIjoiNWY0ZGNjM2I1YWE3NjVkNjFkODMyN2RlYjg4MmNmOTkiLCJpYXQiOjE2Njg1NjQ2Mzh9.okSWemdE9V38FgsZpTEw4YrpRjjdqnqi4N949p57ZYU
            }
        }
    }

    private fun setupRecyclerView() = binding.rvProductFavorite.run {
        adapter = listOrderAdapter
    }


    override fun bindViewModel() {
        //No TODO here
    }

}