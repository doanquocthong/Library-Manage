package com.example.managelibrary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.managelibrary.OutData
import com.example.managelibrary.R
import com.example.managelibrary.RvAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tạo danh sách sách
        val list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.bo_luat_dan_su, "Bộ luật quân sự", "Nhiều tác giả", true))
        list.add(OutData(R.drawable.bi_mat_nghe_dien_gia, "Bí mật nghề diễn giả", "Nguyễn Văn Huy", false))
        list.add(OutData(R.drawable.bi_mat_nghe_dien_gia, "Content maketing", "Trần Văn Bảo", false))
        list.add(OutData(R.drawable.luat_dat_dai, "Luật đất đai", "Trương Đình Hùng", true))
        list.add(OutData(R.drawable.luat_doanh_nghiep, "Luật doanh nghiệp", "Đoàn Văn", true))
        list.add(OutData(R.drawable.phuong_phap_ghi_nho, "Phương pháp ghi nhớ", "Nhiều tác giả", true))

        // Ánh xạ RecyclerView từ layout
        val rvList = view.findViewById<RecyclerView>(R.id.rvList)

        // Thiết lập adapter cho RecyclerView
        val adapter = RvAdapter(list)
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

}