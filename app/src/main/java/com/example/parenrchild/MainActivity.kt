package com.example.parenrchild

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.parenrchild.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 상속해줄 부모클래스는 open을 사용해야한다.
        open class Parent {
            var say: String = ""
            open var age = 100
            fun sayView() {
                Log.d("Parent", "$say")
            }
            open fun test() {
            }
        }

        class Child: Parent() {
            fun childSay() {
                say = "Hi Kotlin"
                sayView()
            }

            override fun test() {
            }

            override var age: Int = 50
        }

        var child = Child()
        child.childSay()


        val button = ActivityMainBinding.inflate(layoutInflater)
        setContentView(button.root)

        button.btn1.setOnClickListener {
            button.text1.text = "${child.age}"
        }
    }
}