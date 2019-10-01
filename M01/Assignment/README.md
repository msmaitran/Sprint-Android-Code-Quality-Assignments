# Android_Debug_NoteTaker

## Introduction

This goal of this project is to debug a Note Taker project. As this is a project specifically intended to help you practice your debugging skills and using the resources available to you, refrain from asking for help unless absolutely necessary.

## Instructions

Please fork and clone this repository. It contains the broken project that you should debug. As this is a project that you have worked on previously, do not use your own completed version of this project as you will gain nothing (in the long term) from referencing it.

As a recap, the project when working properly should:

- Allow the user to create notes that are saved to a Firebase Database and an on-device persistent store using an SQL database
- The device's persistent store is synchronized with the Firebase Database. (When a journal entry is saved to the device's persistent store it gets sent to Firebase, and vice-versa.

## Following Bugs Were Fixed:

**1. Error running 'app': Default Activity not found**
  
- Add MainActivity as LAUNCHER activity in AndroidManifest.xml
  
- Add EditActivity in AndroidManifest.xml
  
- Add SettingsActivity in AndroidManifest.xml
  
**2. Android resource linking failed**
  
- MainActivity: update tools:context="com.lambdaschool.notetaker.MainActivity" in the activity_main.xml file
  
- Implement constraintlayout dependency in gradle file
  
- Update recyclerview in the activity_main.xml file
  
**3. Vector drawables missing**
  
- Add (3) vector drawables for pref_headers

**4. e: [kapt] An exception occurred:java.util.NoSuchElementException:Collection contains no element matching the predicate.**
  
- comment out private set on line 20 of file Note.kt
  
- comment out constructor(id: Long) {this.id = id} on lines 57-58 of file Note.kt
  
**5. NoteViewModel: No value passed for parameter 'context'**
  
- Add parameter: context

**6. NotesDBDao: Unresolved reference: getId**
  
- Change note.getId() to note.id
  
**7. SharedPrefsDao: Unresolved reference: getId**
  
- Change note.getId() to note.id.toString()
  
- Change note.setId(nextId) to note.id = nextId.toLong()
  
**8. NotesDBHelper.kt: 7**
  
- Change DATABASE_VERSION from 0 to 1
  
**9. EditActivity.kt: 19**
  
- EditActivity: update tools:context="com.lambdaschool.notetaker.EditActivity" in the activity_edit.xml file

- Update constraintlayout in the activity_edit.xml file

**10. EditActivity: Null cannot be cast to non-null type**
  
- Change "as Note" to "as Note?"
  
**11. Title not displaying on note_element_layout**
  
- Add var noteTitle under class ViewHolder
  
- Add noteTitle under init
  
- Add noteTitle under onBindViewHolder
  
**12. ...still more bugs**
