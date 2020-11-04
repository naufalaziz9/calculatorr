package com.example.calculator5
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Number Buttons*/

        tv_angka1.setOnClickListener {
            hitung_expression("1", clear = true)
        }

        tv_angka2.setOnClickListener {
            hitung_expression("2", clear = true)
        }

        tv_angka3.setOnClickListener {
            hitung_expression("3", clear = true)
        }
        tv_angka4.setOnClickListener {
            hitung_expression("4", clear = true)
        }

        tv_angka5.setOnClickListener {
            hitung_expression("5", clear = true)
        }

        tv_angka6.setOnClickListener {
            hitung_expression("6", clear = true)
        }

        tv_angka7.setOnClickListener {
            hitung_expression("7", clear = true)
        }

        tv_angka8.setOnClickListener {
            hitung_expression("8", clear = true)
        }

        tv_angka9.setOnClickListener {
            hitung_expression("9", clear = true)
        }

        tv_angka0.setOnClickListener {
            hitung_expression("0", clear = true)
        }

        tv_tandaplus.setOnClickListener {
            hitung_expression("+", clear = true)
        }

        tv_tandamin.setOnClickListener {
            hitung_expression("-", clear = true)
        }

        tv_tandakali.setOnClickListener {
            hitung_expression("*", clear = true)
        }

        tv_tandabagi.setOnClickListener {
            hitung_expression("/", clear = true)
        }

        tv_tandadot.setOnClickListener {
            hitung_expression(".", clear = true)
        }

        tv_tandac.setOnClickListener {
            tv_hasil.text = ""
        }

        tv_tandaac.setOnClickListener {
            tv_ketikan.text = ""
            tv_hasil.text = ""
        }

        tv_tandaf.setOnClickListener {
            var buat_floor = tv_ketikan.text.toString()
            tv_hasil.text = Math.floor(buat_floor.toDouble()).toInt().toString()
//            tv_ketikan.text=""
        }

        tv_tandace.setOnClickListener {
            var buat_ceiling = tv_ketikan.text.toString()
            tv_hasil.text = Math.ceil(buat_ceiling.toDouble()).toInt().toString()
//            tv_ketikan.text=""
        }

        tv_tandard.setOnClickListener {
//            val buat_round = tv_ketikan
            var buat_round = tv_ketikan.text.toString()
            tv_hasil.text=(Math.round(buat_round.toDouble()*10.0)/10.0).toString()
        }

        tv_tandasquare.setOnClickListener {
            var buat_square = tv_ketikan.text.toString()
            tv_hasil.text = (buat_square.toDouble() * buat_square.toDouble()).toString()
        }

        tv_tandasqrt.setOnClickListener {
            var buat_sqrt = tv_ketikan.text.toString()
            tv_hasil.text = Math.sqrt(buat_sqrt.toDouble()).toInt().toString()
        }

        tv_tandasd.setOnClickListener {
            val ketikan_string = tv_ketikan.text.toString()
            val expression = ExpressionBuilder(ketikan_string).build()

            val hasil = expression.evaluate()
            val hasil_long = hasil.toLong()
            if (hasil == hasil_long.toDouble()) {
                tv_hasil.text = hasil_long.toString()
            } else {
                tv_hasil.text = hasil.toString()
            }
        }

//        tvBack.setOnClickListener {
//            val text = tvExpression.text.toString()
//            if(text.isNotEmpty()) {
//                tvExpression.text = text.drop(1)
//            }
//
//            tvResult.text = ""
//        }
    }

    fun hitung_expression(string: String, clear: Boolean) {
        if(clear) {
            tv_hasil.text = ""
            tv_ketikan.append(string)
        }
        else {
            tv_ketikan.append(tv_hasil.text)
            tv_ketikan.append(string)
            tv_hasil.text = ""
        }
    }
}