
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bili.adapter.ViewPager2Adapter
import com.example.bili.databinding.AdapterRecyclerviewBinding
import com.example.bili.model.UpList

class RecyclerAdapter(
    private var upList:List<UpList>,
    private val onItemClickListener:OnItemClickListener
):RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){
    interface OnItemClickListener{
        fun OnItemClick(position:Int)
        fun OnLongItemClick(position:Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): RecyclerAdapter.MyViewHolder {
        val binding = AdapterRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {
        val item = upList[position]
        holder.binding.id.text = item.id
        holder.binding.imageView.setImageResource(item.imageResId)
        holder.binding.root.setOnClickListener{
            onItemClickListener.OnItemClick(position)
        }
        holder.binding.root.setOnLongClickListener{
            onItemClickListener.OnLongItemClick(position)
            true
        }
    }

    override fun getItemCount() = upList.size

    class MyViewHolder(val binding:AdapterRecyclerviewBinding):RecyclerView.ViewHolder(binding.root)
}