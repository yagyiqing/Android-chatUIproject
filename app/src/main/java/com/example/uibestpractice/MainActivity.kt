package com.example.uibestpractice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uibestpractice.ui.theme.UIBestPracticeTheme

class MainActivity : ComponentActivity() ,View.OnClickListener{
    private val msglist = ArrayList<Msg>()
    private lateinit var send: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var inputText: EditText
    private lateinit var adapter: MsgAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        send = findViewById(R.id.button)
        recyclerView = findViewById(R.id.recycvlerview)
        inputText = findViewById(R.id.inputText)

        initMsg()
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MsgAdapter(msglist)
        recyclerView.adapter = adapter


        send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v){
            send->{
                val content = inputText.text.toString()
                if(content.isNotEmpty()){
                    val msg = Msg(content,Msg.TYPE_SENT)
                    msglist.add(msg)
                    adapter?.notifyItemInserted(msglist.size-1)
                    recyclerView.scrollToPosition(msglist.size-1)
                    inputText.setText("")
                }
            }
        }
    }

    private fun initMsg()
    {
        val msg1 = Msg("Hello guy",Msg.TYPE_RECEIVED)
        msglist.add(msg1)
        val msg2 = Msg("Hello,I am 吴钟干",Msg.TYPE_SENT)
        msglist.add(msg2)
        val msg3 = Msg("Oh!I know you",Msg.TYPE_RECEIVED)
        msglist.add(msg3)
        val msg4 = Msg("What?",Msg.TYPE_SENT)
        msglist.add(msg4)
        val msg5 = Msg("DayBreak彭于晏",Msg.TYPE_RECEIVED)
        msglist.add(msg5)
    }
}