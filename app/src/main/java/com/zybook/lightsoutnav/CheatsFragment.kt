package com.zybook.lightsoutnav

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.children

class CheatsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_cheats, container, false)

        // Extract cheat value from SharedPreferences
        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val winCheatEnabled = sharedPref.getBoolean ("win_cheat", false)

        //set win cheat enabled or not
        val winCheatCheck = rootView.findViewById<CheckBox>(R.id.checkbox_enable_win_cheat)
        winCheatCheck.isChecked = winCheatEnabled

        winCheatCheck.setOnClickListener(this::onCheckClicked)

        return rootView
    }

    private fun onCheckClicked(view: View) {
        // Save cheat selected in SharedPreferences
        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("win_cheat", view.findViewById<CheckBox>(R.id.checkbox_enable_win_cheat).isChecked)
        editor.apply()
    }
}