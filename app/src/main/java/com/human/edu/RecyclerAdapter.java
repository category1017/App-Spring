package com.human.edu;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {
    //멤버변수
    public OnItemClickListener mOnItemClickListener;
    private List mList;

    //클래스 생성자 만들기 //SubActivity에서 호출할때, RestAPI에서 받은 json를 매개변수로 받음.
    public RecyclerAdapter(List itemList){
        mList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        //인플레이트 = 렌더링 =화면에 뿌려줌
        return new ItemViewHolder(view);
    }
    //개발자가 호출하는 것이 아니고, 안드로이드의 레이아웃 관리자가 자동으로 호출합니다.
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ItemViewHolder holder, int position) {
        MemberVO memberVO = (MemberVO) mList.get(position);
        holder.itemId.setText(memberVO.getUser_id());
        holder.itemName.setText(memberVO.getUser_name());
        holder.itemEmail.setText(memberVO.getEmail());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setmList(List mList) {
        this.mList = mList;
    }

    //중첩클래스 생성
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        //멤버변수선언
        private TextView itemId;
        private TextView itemName;
        private TextView itemEmail;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemId = itemView.findViewById(R.id.textViewId);
            itemName = itemView.findViewById(R.id.textViewName);
            itemEmail = itemView.findViewById(R.id.textViewEmail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int pos = getAdapterPosition();//리사이클러뷰의 항목을 클릭한 위치
                    Log.i("디버그 getAdapterPosition", String.valueOf(pos));
                    if(pos != RecyclerView.NO_POSITION){ //손가락으로 클릭했다면
                        if(mOnItemClickListener != null){
                            mOnItemClickListener.onItemClick(v,pos);
                        }
                    }
                }
            });
        }
    }
}
