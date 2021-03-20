package com.example.foodmarket.ui.order.pastorders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodmarket.R
import com.example.foodmarket.model.response.transaction.Data
import kotlinx.android.synthetic.main.fragment_past_orders.*


class PastOrdersFragment : Fragment(), PastOrdersAdapter.ItemAdapterCallback {

    private var adapter: PastOrdersAdapter? = null
    var pastOrdersList: ArrayList<Data>? = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_past_orders, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        pastOrdersList = arguments?.getParcelableArrayList("data")

        if (!pastOrdersList.isNullOrEmpty()) {
            adapter = PastOrdersAdapter(pastOrdersList!!, this)
            val layoutManager = LinearLayoutManager(activity)
            rcList.layoutManager = layoutManager
            rcList.adapter = adapter
        }

    }

    override fun onClick(v: View, data: Data) {
        Toast.makeText(activity, "coba klik", Toast.LENGTH_LONG).show()
    }
}