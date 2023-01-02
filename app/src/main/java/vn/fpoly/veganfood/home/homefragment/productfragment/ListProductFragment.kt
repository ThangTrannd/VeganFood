package vn.fpoly.veganfood.home.homefragment.productfragment

import android.content.Intent
import android.os.Bundle
import vn.fpoly.veganfood.R
import vn.fpoly.veganfood.basekotlin.base.BaseFragment
import vn.fpoly.veganfood.basekotlin.base.BaseViewModel
import vn.fpoly.veganfood.basekotlin.extensions.viewBinding
import vn.fpoly.veganfood.databinding.FragmentListProductBinding
import vn.fpoly.veganfood.dialog.DialogUtils
import vn.fpoly.veganfood.feature.product_detail.ProductDetailActivity
import vn.fpoly.veganfood.model.ProductsByCategoryResult
import vn.fpoly.veganfood.network.NetWorkController
import vn.fpoly.veganfood.network.TCCCallback
import vn.fpoly.veganfood.util.NetworkUtils
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber

class ListProductFragment : BaseFragment(R.layout.fragment_list_product) {

    override val binding: FragmentListProductBinding by viewBinding()
    override val viewModel: BaseViewModel
        get() = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getString(ID_CATEGORY)?.let { it1 -> getProductList(it1.toInt()) }
        }
    }

    private val listProductAdapter by lazy(LazyThreadSafetyMode.NONE) {
        ListProductAdapter(onItemClick = {
            val intent = Intent(requireActivity(), ProductDetailActivity::class.java)
            intent.putExtra("idProduct", it)
            startActivity(intent)
        })
    }

    override fun setupViews() {
        setupRecyclerView()
    }


    private fun getProductList(id: Int) {
        DialogUtils.showProgressDialog(requireActivity())
        if (NetworkUtils.isConnect(requireActivity())) {
            NetWorkController.getListProductByCategory(object :
                TCCCallback<ProductsByCategoryResult>() {
                override fun onTCTCSuccess(
                    call: Call<ProductsByCategoryResult>?,
                    response: Response<ProductsByCategoryResult>?
                ) {
                    listProductAdapter.submitList(response?.body()?.results)
                    DialogUtils.dismissProgressDialog()
                }

                override fun onTCTCFailure(call: Call<ProductsByCategoryResult>?) {
                    Timber.tag(call.toString())
                    DialogUtils.dismissProgressDialog()
                }
            }, id)
        }
    }

    override fun bindViewModel() {
        //No TODO here
    }

    private fun setupRecyclerView() = binding.rvProduct.run {
        adapter = listProductAdapter
    }


    companion object {
        private var ID_CATEGORY: String = ""

        @JvmStatic
        fun newInstance(category: String) = ListProductFragment().apply {
            arguments = Bundle().apply {
                putString(ID_CATEGORY, category)
            }
        }
    }
}