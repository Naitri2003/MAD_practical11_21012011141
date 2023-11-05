package com.naitri.mad_practical11_21012011141

class PersonTable {
    companion object{
        val TABLE_NAME = "person"
        val COLUMN_ID ="id"
        val COLUMN_NAME ="person_name"
        val COLUMN_PERSON_EMAIL_ID = "person_email_id"
        val COLUMN_PERSON_PHONE_NO = "person_phone_no"
        val COLUMN_PERSON_ADDRESS = "person_address"
        val COLUMN_PERSON_GPS_LAT = "person_lat"
        val COLUMN_PERSON_GPS_LOG = "person_log"


        val CREATE_TABLE =("CREATE_TABLE" + TABLE_NAME + "("
                + COLUMN_ID + "TEXT PRIMARY KRY,"
                + COLUMN_NAME + "TEXT,"
                + COLUMN_PERSON_EMAIL_ID + "TEXT,"
                + COLUMN_PERSON_PHONE_NO + "TEXT,"
                + COLUMN_PERSON_ADDRESS + "TEXT,"
                + COLUMN_PERSON_GPS_LAT + "REAL,"
                + COLUMN_PERSON_GPS_LOG + "REAL,"
                + ")")
    }
}