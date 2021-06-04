package com.dibaliqaja.githubuserapp.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dibaliqaja.githubuserapp.data.model.Reminder
import com.dibaliqaja.githubuserapp.databinding.ActivitySettingsBinding
import com.dibaliqaja.githubuserapp.preference.ReminderPreference
import com.dibaliqaja.githubuserapp.receiver.AlarmReceiver

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var reminder: Reminder
    private lateinit var alarmReceiver: AlarmReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val reminderPreference = ReminderPreference(this)
        binding.switch1.isChecked = reminderPreference.getReminder().isReminded

        alarmReceiver = AlarmReceiver()
        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                saveReminder(true)
                alarmReceiver.setRepeatingAlarm(this, "RepeatingAlarm", "06:58", "Github Reminder")
            } else {
                saveReminder(false)
                alarmReceiver.cancelAlarm(this)
            }
        }
    }

    private fun saveReminder(b: Boolean) {
        val reminderPreference = ReminderPreference(this)
        reminder = Reminder()
        reminder.isReminded = b
        reminderPreference.setReminder(reminder)
    }
}