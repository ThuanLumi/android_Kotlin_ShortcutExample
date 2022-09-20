package com.office.shortcutexample

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService

const val shortcut_website_id = "id_website"
const val shortcut_messages_id = "id_messages"

@RequiresApi(Build.VERSION_CODES.N_MR1)
object Shortcuts {
    fun setUp(context: Context) {
        val shortcutManager =
            getSystemService<ShortcutManager>(context, ShortcutManager::class.java)

        val shortcutWebsite = ShortcutInfo.Builder(context, shortcut_website_id)
            .setShortLabel("Website")
            .setLongLabel("Open the Website!")
            .setIcon(Icon.createWithResource(context, R.drawable.ic_baseline_public_24))
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/codepalace")))
            .build()

        val intents = arrayOf(
            Intent(Intent.ACTION_VIEW, null, context, MainActivity::class.java),
            Intent(Intent.ACTION_VIEW, null, context, Messages::class.java)
        )

        val shortcutMessages = ShortcutInfo.Builder(context, shortcut_messages_id)
            .setShortLabel("Messages")
            .setLongLabel("Send a message!")
            .setIcon(Icon.createWithResource(context, R.drawable.ic_baseline_message_24))
            .setIntents(intents)
            .build()

        shortcutManager!!.dynamicShortcuts = listOf(shortcutWebsite, shortcutMessages)
    }
}