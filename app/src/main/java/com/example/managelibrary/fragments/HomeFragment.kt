package com.example.managelibrary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.managelibrary.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = view.findViewById<ListView>(R.id.listView)
        val edtNewBook = view.findViewById<EditText>(R.id.etNewBook)
        val btnAdd = view.findViewById<Button>(R.id.btnAdd)
        val bookList = mutableListOf("Sách 1", "Sách 2")
        val lvBooks = listView
        // Tạo Adapter cho ListView
        val bookAdapter = ArrayAdapter(requireContext(), R.layout.simple_list_item, R.id.item, bookList)
        lvBooks.adapter = bookAdapter

        // Xử lý sự kiện nút "Thêm"
        btnAdd.setOnClickListener {
            val newBook = edtNewBook.text.toString().trim()
            if (newBook.isNotEmpty()) {
                bookList.add(newBook) // Thêm sách vào danh sách
                bookAdapter.notifyDataSetChanged() // Cập nhật ListView
                edtNewBook.text.clear() // Xóa nội dung nhập
                Toast.makeText(requireContext(), "Đã thêm sách: $newBook", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Vui lòng nhập tên sách", Toast.LENGTH_SHORT).show()
            }
        }
    }
}