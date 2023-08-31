package com.appsinvo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appsinvo.databinding.FragmentMyBookingBinding

private var _binding: FragmentMyBookingBinding? = null

private val binding get() = _binding!!
class MyBooking : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle? ,
    ): View?
    {
        return inflater.inflate(R.layout.fragment_my__booking , container , false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}