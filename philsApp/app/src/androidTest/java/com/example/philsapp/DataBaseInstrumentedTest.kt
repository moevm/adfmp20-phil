package com.example.philsapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.philsapp.api.Database
import junit.framework.Assert.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DataBaseInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.philsapp", appContext.packageName)
    }

    @Test
    fun testConnect() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val db = Database(context)
        val data = db.getAllPhilosophers()
        data.forEach { it ->
            assertNotNull(it.name)
            assertNotNull(it.wikiPageId)
        }
    }
}
