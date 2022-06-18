package com.robisubagja.robisubagja

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.robisubagja.robisubagja.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listCharacter = ArrayList<pemain>()
        listCharacter.add(
            pemain(
                "Jett",
                R.drawable.jett,
                "Duelist",
                "Representing her home country of South Korea, Jett's agile and evasive fighting style lets her take risks no one else can. She runs circles around every skirmish, cutting enemies before they even know what hit them."
            )
        )
        listCharacter.add(
            pemain(
                "Fade",
                R.drawable.fade,
                "Initiator",
                "Turkish bounty hunter, Fade, unleashes the power of raw nightmares to seize enemy secrets. Attuned with terror itself, she hunts targets and reveals their deepest fears—before crushing them in the dark."
            )
        )
        listCharacter.add(
            pemain(
                "Chamber",
                R.drawable.chamber,
                "Sentinel",
                "Well dressed and well armed, French weapons designer Chamber expels aggressors with deadly precision. He leverages his custom arsenal to hold the line and pick off enemies from afar, with a contingency built for every plan."
            )
        )
        listCharacter.add(
            pemain(
                "Viper",
                R.drawable.viper,
                "Controller",
                "The American chemist, Viper deploys an array of poisonous chemical devices to control the battlefield and cripple the enemy's vision. If the toxins don't kill her prey, her mind games surely will."
            )
        )
        listCharacter.add(
            pemain(
                "Yoru",
                R.drawable.yoru,
                "Duelist",
                "Japanese native, yoru, rips holes straight through reality to infiltrate enemy lines unseen. Using deception and aggression in equal measure, he gets the drop on each target before they know where to look."
            )
        )


        binding.list.adapter =
            Adapterpemain(this, listCharacter, object : Adapterpemain.OnClickListener {
                override fun detailData(item: pemain?) {
                    Dialog(this@MainActivity).apply {
                        requestWindowFeature(Window.FEATURE_NO_TITLE)
                        setCancelable(true)
                        setContentView(R.layout.detail_data_character)

                        val image = this.findViewById<ImageView>(R.id.image_character)
                        val nama = this.findViewById<TextView>(R.id.txtnamacharacter)

                        val role = this.findViewById<TextView>(R.id.txtrolecharacter)
                        val biograpy = this.findViewById<TextView>(R.id.txtbiograpycharacter)
                        val btn = this.findViewById<Button>(R.id.btnclose)

                        image.setImageResource(item?.foto ?:0)
                        nama.text = "${item?.nama}"
                        role.text = "${item?.role}"
                        biograpy.text = "${item?.biograpy}"

                        btn.setOnClickListener{
                            this.dismiss()
                        }

                    }.show()
                }

            })

    }
}

