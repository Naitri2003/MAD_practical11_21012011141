package com.naitri.mad_practical11_21012011141

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class PersonAdapter (val context: Context,val personArray: ArrayList<Person>):RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(val view: View):RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personArray.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val view=holder.view
        view.findViewById<TextView>(R.id.textName1)
        view.findViewById<TextView>(R.id.text_no)
        view.findViewById<TextView>(R.id.textemail)
        view.findViewById<TextView>(R.id.textaddress)
        view.findViewById<MaterialButton>(R.id.location).setOnClickListener {
            Intent(context, MapsActivity::class.java).putExtra("Object", personArray[position])
                .apply { context.startActivity(this) }
        }
    }
}