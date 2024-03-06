package com.example.job2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ProfileAdapter(private val profileList: List<Profile>) :
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    private var mOnItemClick: Listener? = null
    private var mOnEditClick: Listener? = null
    private var mOnDeleteClick: Listener? = null

    inner class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var uName = view.findViewById<TextView>(R.id.nameT)
        var uAddress = view.findViewById<TextView>(R.id.addressT)
        var uCity = view.findViewById<TextView>(R.id.cityT)
        var editBtn = view.findViewById<Button>(R.id.editBtn)
        var deleteBtn = view.findViewById<Button>(R.id.deleteBtn)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return profileList.count()
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val itemPosition = profileList[position]
        holder.uName.text = itemPosition.name
        holder.uAddress.text = itemPosition.address
        holder.uCity.text = itemPosition.city
        holder.editBtn.setOnClickListener {
            mOnEditClick!!.onEditClick(position,itemPosition)
        }
        holder.deleteBtn.setOnClickListener {
            mOnDeleteClick!!.onDeleteClick(position,itemPosition)
        }
        holder.itemView.setOnClickListener {
            mOnItemClick!!.onItemClick(position,itemPosition)
        }
    }
    fun setOnClickListener(listener: Listener){
        this.mOnItemClick = listener
        this.mOnEditClick = listener
        this.mOnDeleteClick = listener
    }
    interface Listener{
        fun onItemClick(position: Int,profile: Profile)
        fun onEditClick(position: Int,profile: Profile)
        fun onDeleteClick(position: Int,profile: Profile)
    }

}


