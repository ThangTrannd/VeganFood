package vn.fpoly.veganfood.home.search

import android.content.Intent
import androidx.core.widget.doOnTextChanged
import vn.fpoly.veganfood.R
import vn.fpoly.veganfood.basekotlin.base.BaseActivity
import vn.fpoly.veganfood.basekotlin.base.BaseViewModel
import vn.fpoly.veganfood.basekotlin.extensions.viewBinding
import vn.fpoly.veganfood.databinding.FragmentSearchBinding
import vn.fpoly.veganfood.dialog.DialogUtils
import vn.fpoly.veganfood.feature.product_detail.ProductDetailActivity
import vn.fpoly.veganfood.model.ProductsResult
import vn.fpoly.veganfood.model.ProductsResult.ProductsResultModel
import vn.fpoly.veganfood.network.NetWorkController
import vn.fpoly.veganfood.network.TCCCallback
import vn.fpoly.veganfood.util.NetworkUtils
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber

class SearchActivity : BaseActivity(R.layout.fragment_search) {
    override val binding: FragmentSearchBinding by viewBinding()
    override val viewModel: BaseViewModel
        get() = TODO("Not yet implemented")

    private val listProductAdapter by lazy(LazyThreadSafetyMode.NONE) {
        SearchProductAdapter(onItemClick = {
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("idProduct", it)
            startActivity(intent)
        })
    }

    var list: List<ProductsResultModel>? = null

    override fun setupViews() {
        setupRecyclerView()
        getProductList()
        binding.edtSearch.doOnTextChanged { text, _, _, _ ->
            searchProduct(text.toString())
            if (text.isNullOrEmpty()){
                binding.rvSearch.scrollToPosition(0)
            }
        }
        binding.icBack.setOnClickListener {
            finish()
        }
    }

    private fun searchProduct(name: String) {
        if (!list.isNullOrEmpty()) {
            listProductAdapter.submitList(list!!.filter {
                it.productName.contains(name, ignoreCase = true)
            })
        }
    }

    private fun getProductList() {
        DialogUtils.showProgressDialog(this)
        if (NetworkUtils.isConnect(this)) {
            NetWorkController.getListProduct(object :
                TCCCallback<ProductsResult>() {
                override fun onTCTCSuccess(
                    call: Call<ProductsResult>?,
                    response: Response<ProductsResult>?
                ) {
                    list = response?.body()?.results
                    DialogUtils.dismissProgressDialog()
                }

                override fun onTCTCFailure(call: Call<ProductsResult>?) {
                    Timber.tag(call.toString())
                    DialogUtils.dismissProgressDialog()
                }
            })
        }
    }

    private fun setupRecyclerView() = binding.rvSearch.run {
        adapter = listProductAdapter
    }

    override fun bindViewModel() {
        //No TODO here
    }

}