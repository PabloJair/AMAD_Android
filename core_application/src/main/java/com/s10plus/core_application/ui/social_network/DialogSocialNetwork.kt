package com.s10plus.core_application.ui.social_network

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import com.s10plus.core_application.databinding.DialogSocialNetworkBinding
import com.s10plus.core_application.models.SocialNetWorkModel

class DialogSocialNetwork: DialogFragment() {

    private lateinit var binding: DialogSocialNetworkBinding

    var selection:
            (( String,DialogFragment) -> Unit)? = null;

    var items = listOf<SocialNetWorkModel>()
    var title = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridAdapter = GridAdapterSocialNetwork(
                requireContext(), items).apply {

            onClick= {
                selection?.invoke(it.url?:"",this@DialogSocialNetwork);
            }
        }
        binding.tittle.text = title
        binding.recyclerView.layoutManager =  GridLayoutManager(requireContext(),
                2, GridLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = gridAdapter
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DialogSocialNetworkBinding.inflate(inflater, container, true)
        return binding.root

    }
    private fun go(socialNetwork:SocialNetWorkModel){

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(socialNetwork?.url))
        startActivity(intent)

    }
    companion object {
        fun show(supportFragment: FragmentManager, click: ((String,DialogFragment)->Unit)? = null) {

            val ft = supportFragment.beginTransaction()
            val prev = supportFragment.findFragmentByTag("dialog-password")
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);
            newInstance().apply {

                selection =click
                items = SocialNetWorkModel.getListMenu()
            }.show(ft, "dialog-password")
        }

        fun newInstance(): DialogSocialNetwork {

            return DialogSocialNetwork()
        }


    }

}