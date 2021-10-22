package com.example.mvpv2.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpv2.Apiinterface
import com.example.mvpv2.ItemClick
import com.example.mvpv2.MyDataItem
import com.example.mvpv2.R
import com.example.mvpv2.adapters.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_ticket.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.dastyor.arzonkassa.Adapter.HeaderAdapter
import java.util.ArrayList

const val BASE_URL="https://608bc945737e470017b754f0.mockapi.io/api/v1/"
class home : Fragment(),ItemClick{

    lateinit var adapter: RecyclerAdapter
    lateinit var headerAdapter :HeaderAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTicket.setHasFixedSize(true)
        adapter = RecyclerAdapter(this)
        headerAdapter = HeaderAdapter()
        val concatAdapter =ConcatAdapter(headerAdapter,adapter,)
        linearLayoutManager = LinearLayoutManager(context)
        rvTicket.adapter=concatAdapter
        rvTicket.layoutManager=linearLayoutManager
        getMyData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onItemClicked(position: Int) {
        val intent = Intent(requireContext() , OrderActivity::class.java)
        startActivity(intent)
    }


    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build().create(
            Apiinterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object: Callback<ArrayList<MyDataItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<ArrayList<MyDataItem>?>,
                response: Response<ArrayList<MyDataItem>?>
            ) {
                val responseBody=response.body()!!
                adapter.updateList(responseBody)
                adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<ArrayList<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity","onFailure: "+t.message)
            }

        }
        )
    }
}

