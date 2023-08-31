package com.appsinvo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appsinvo.databinding.FragmentScanQrBinding


private var _binding: FragmentScanQrBinding? = null

private val binding get() = _binding!!

class Scan_Qr : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle? ,
    ): View?
    {
        return inflater.inflate(R.layout.fragment_scan__qr , container , false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}