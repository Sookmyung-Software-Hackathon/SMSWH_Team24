package com.example.babyak;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatFragment extends Fragment {
    ArrayList<ChatData> list = new ArrayList<>();
    ListView lv;
    Button sendBtn;
    EditText edt;
    int[] imageID = {R.drawable.ic_launcher_foreground};

    String id = "";



    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ChatFragment() {
        // Required empty public constructor
    }

    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

////        lv = (ListView) getView().findViewById(R.id.chat_listView);
////        edt = (EditText) getView().findViewById(R.id.chat_editText);
////        sendBtn = (Button) getView().findViewById(R.id.chat_sendBtn);
//
//
//        // Firedb에 메시지 쓰기
//        FirebaseDatabase db = FirebaseDatabase.getInstance();
//        final DatabaseReference myRef = db.getReference("message");
//
//        // 로그인한 아이디
//        id = "id";
//
//        final ChatAdapter ca = new ChatAdapter(getActivity().getApplicationContext(), R.layout.chat_item, list, id);
//        ((ListView) getView().findViewById(R.id.chat_listView)).setAdapter(ca);
//
//
//        StringBuffer sb = new StringBuffer("hi");
//        myRef.push().setValue(new ChatData(R.drawable.ic_launcher_foreground, id, sb.toString()));
//
//        // 입력 버튼 클릭 시
////        sendBtn.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
//////                if (edt.getText().toString().equals("")) {
//////                    Toast.makeText(getActivity().getApplicationContext(), "내용을 입력하세요.", Toast.LENGTH_SHORT).show();
//////                }
////                //else {
////                    //StringBuffer sb = new StringBuffer(edt.getText().toString());
////                    StringBuffer sb = new StringBuffer("hi");
////                    if (sb.length() > 15){
////                        for (int i = 0; i < sb.length() / 15; i++)
////                            sb.insert(15 * i, "\n");
////                    }
////
////                    myRef.push().setValue(new ChatData(R.drawable.ic_launcher_foreground, id, sb.toString()));
////                    //edt.setText("");
////                //}
////            }
////        });
////
//        myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                ChatData value = snapshot.getValue(ChatData.class);
//                list.add(value);
//                ca.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chat, container, false);

        lv = (ListView) v.findViewById(R.id.chat_listView);
        edt = (EditText) v.findViewById(R.id.chat_editText);
        sendBtn = (Button) v.findViewById(R.id.chat_sendBtn);

        // Firedb에 메시지 쓰기
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = db.getReference("message");

        // 로그인한 아이디
        id = "other";

        final ChatAdapter ca = new ChatAdapter(getActivity().getApplicationContext(), R.layout.chat_item, list, id);
        ((ListView) v.findViewById(R.id.chat_listView)).setAdapter(ca);


        // 입력 버튼 클릭 시
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt.getText().toString().equals("")) {
                    Toast.makeText(getActivity().getApplicationContext(), "내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    StringBuffer sb = new StringBuffer(edt.getText().toString());
                    if (sb.length() > 15){
                        for (int i = 0; i < sb.length() / 15; i++)
                            sb.insert(15 * i, "\n");
                    }

                    myRef.push().setValue(new ChatData(R.drawable.ic_launcher_foreground, id, sb.toString()));
                    edt.setText("");
                }
            }
        });

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                ChatData value = snapshot.getValue(ChatData.class);
                list.add(value);
                ca.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return v;
    }
}