package com.example.babyak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<ChatData> chatData;
    private LayoutInflater inflater;
    private String id;


    public ChatAdapter(Context applicationContext, int chat_item, ArrayList<ChatData> list, String id) {
        this.context = applicationContext;
        this.layout = chat_item;
        this.chatData = list;
        // 레이아웃을 뷰로 바꾸기 위해(inflate) Context에서 inflater를 추출
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.id = id;
    }

    @Override
    public int getCount() { // 전체 데이터 개수
        return chatData.size();
    }

    @Override
    public Object getItem(int position) { // position번째 아이템
        return chatData.get(position);
    }

    @Override
    public long getItemId(int position) { // position번째 항목의 id. 보통 position
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //항목의 index, 전에 inflate 되어있는 view, listView
        //첫항목을 그릴때만 inflate 함 다음거부터는 매개변수로 넘겨줌 (느리기때문) : recycle
        ViewHolder holder;

        if(convertView == null){
            //어떤 레이아웃을 만들어 줄 것인지, 속할 컨테이너, 자식뷰가 될 것인지
            convertView = inflater.inflate(layout, parent, false); //아이디를 가지고 view를 만든다
            holder = new ViewHolder();
            holder.img = (ImageView)convertView.findViewById(R.id.pt_image);
            holder.pt_msg = (TextView)convertView.findViewById(R.id.pt_content);
            holder.pt_name = (TextView)convertView.findViewById(R.id.pt_id);
            holder.my_msg = (TextView)convertView.findViewById(R.id.my_content);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //누군지 판별
        // 내 메시지일 때
        if(chatData.get(position).getId().equals(id)){
            // 상대방 메시지들을 안 보이게 함
            holder.pt_name.setVisibility(View.GONE);
            holder.pt_msg.setVisibility(View.GONE);
            holder.img.setVisibility(View.GONE);

            holder.my_msg.setVisibility(View.VISIBLE);

            holder.my_msg.setText(chatData.get(position).getContent());
        }else{
            holder.pt_name.setVisibility(View.VISIBLE);
            holder.pt_msg.setVisibility(View.VISIBLE);
            holder.img.setVisibility(View.VISIBLE);

            // 내 메시지를 안 보이게 함
            holder.my_msg.setVisibility(View.GONE);

            holder.img.setImageResource(chatData.get(position).getImageID()); // 해당 사람의 프사 가져옴
            holder.pt_msg.setText(chatData.get(position).getContent());
            holder.pt_name.setText(chatData.get(position).getId());
        }


        return convertView;
    }

    //뷰홀더패턴
    public class ViewHolder{
        ImageView img;
        TextView pt_msg;
        TextView pt_name;
        TextView my_msg;
    }
}
