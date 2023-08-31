package com.appsinvo.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appsinvo.R
import com.appsinvo.databinding.FragmentMyqrBinding


private var  _binding: FragmentMyqrBinding? = null

    private val binding get() = _binding!!

class MyQrFragment : Fragment()
{
        override fun onCreateView(
            inflater: LayoutInflater , container: ViewGroup? ,
            savedInstanceState: Bundle? ,
        ): View?
        {
            return inflater.inflate(R.layout.fragment_myqr , container , false)
        }
    override fun onDestroyView() {
        super.onDestroyView()
        var _binding = null
    }
}