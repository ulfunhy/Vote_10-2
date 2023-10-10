package kr.hs.emirim.s2233.vote_10_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "아이돌 선호도 투표"

        var voteCount = IntArray(9)
//        int[] voteCount = new int[9];
        for(i in 0 .. 8)
            voteCount[i] = 0

        var imgV = arrayOfNulls<ImageView>(9)

        var imgVId = arrayOf(R.id.char1, R.id.char2, R.id.char3,
                                    R.id.char4, R.id.char5, R.id.char6,
                                    R.id.char7, R.id.char8, R.id.char9)

        var imgName = arrayOf("짱구", "짱아", "흰둥이",
                                    "철수", "유리", "훈이",
                                    "맹구", "와니야마상", "부리부리대마왕")

        for(i in imgVId.indices){
            imgV[i] = findViewById(imgVId[i])
            imgV[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i] + voteCount[i] + "표", Toast.LENGTH_SHORT).show()
            }
        }
        var btnResult = findViewById<Button>(R.id.btnResult)
        btnResult.setOnClickListener {
            var intent = Intent(applicationContext, activity_result::class.java)
            intent.putExtra("voteCount", voteCount)
            intent.putExtra("imgName", imgName)
            startActivity(intent)
        }
    }
}