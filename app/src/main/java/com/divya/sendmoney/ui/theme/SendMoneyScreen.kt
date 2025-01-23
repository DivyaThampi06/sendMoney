package com.divya.sendmoney.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken



val jsonData = """
{
    "title": {
        "en": "Send Money",
        "ar": "إرسال األموال"
    },
    "services": [
        {
            "label": {
                "en": "Bank Transfer",
                "ar": "التحويل البنكي"
            },
            "name": "bank_transfer",
            "providers": [
                {
                    "name": "ABC Bank",
                    "id": "101",
                    "required_fields": [
                        {
                            "label": {
                                "en": "Amount (AED)",
                                "ar": "المبلغ (درهم)"
                            },
                            "name": "amount",
                            "placeholder": {
                                "en": "0.00",
                                "ar": "0.00"
                            },
                            "type": "number",
                            "validation": "",
                            "max_length": 0,
                            "validation_error_message":  {
                                "en": "Amount is required",
                                "ar": "المبلغ مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Bank Account Number",
                                "ar": "رقم الحساب المصرفي"
                            },
                            "name": "bank_account_number",
                            "placeholder": null,
                            "type": "text",
                            "validation": "^[A-Za-z0-9 ]{1,64}${'$'}",
                            "max_length": 64,
                            "validation_error_message":  {
                                "en": "Bank account number is required",
                                "ar": "رقم الحساب البنكي مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "First name",
                                "ar": "االسم األول"
                            },
                            "name": "firstname",
                            "placeholder": {
                                "en": "Please enter the first name",
                                "ar": "الرجاء إدخال الاسم الأول"
                            },
                            "type": "text",
                            "validation": "^[\\s\\S]*",
                            "max_length": 250,
                            "validation_error_message":  {
                                "en": "First name is required",
                                "ar": "الاسم الأول مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Last name",
                                "ar": "اسم العائلة"
                            },
                            "name": "lastname",
                            "placeholder": {
                                "en": "Please enter the last name",
                                "ar": "الرجاء إدخال الاسم الأخير"
                            },
                            "type": "text",
                            "validation": "^[\\s\\S]*",
                            "max_length": 250,
                            "validation_error_message":  {
                                "en": "Last name is required",
                                "ar": "الاسم الأخير مطلوب"
                            }
                        }
                    ]
                },
                {
                    "name": "XYZ Bank",
                    "id": "102",
                    "required_fields": [
                        {
                            "label": {
                                "en": "Amount (AED)",
                                "ar": "المبلغ (درهم)"
                            },
                            "name": "amount",
                            "placeholder": {
                                "en": "0.00",
                                "ar": "0.00"
                            },
                            "type": "number",
                            "validation": "",
                            "max_length": 0,
                            "validation_error_message":  {
                                "en": "Amount is required",
                                "ar": "المبلغ مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Bank Account Number",
                                "ar": "رقم الحساب المصرفي"
                            },
                            "name": "bank_account_number",
                            "placeholder": null,
                            "type": "text",
                            "validation": "^[A-Za-z0-9 ]{1,64}${'$'}",
                            "max_length": 64,
                            "validation_error_message":  {
                                "en": "Bank account number is required",
                                "ar": "رقم الحساب البنكي مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Full Name",
                                "ar": "االسم الكامل"
                            },
                            "name": "full_name",
                            "placeholder": {
                                "en": "Enter full name",
                                "ar": "أدخل االسم الكامل"
                            },
                            "type": "text",
                            "validation": "^[\\s\\S]*",
                            "max_length": 250,
                            "validation_error_message": {
                                "en": "Full name is required",
                                "ar": "االسم الكامل مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Province State",
                                "ar": "اإلمارة"
                            },
                            "name": "province_state",
                            "placeholder": null,
                            "options": [
                                {
                                    "label": "Abu Dhabi",
                                    "name": "abu_dhabi"
                                },
                                {
                                    "label": "Dubai",
                                    "name": "dubai"
                                }
                            ],
                            "type": "option",
                            "validation": "^[\\s\\S]*",
                            "max_length": 0,
                            "validation_error_message":  {
                                "en": "",
                                "ar": ""
                            }
                        }
                    ]
                },
                {
                    "name": "Global Bank",
                    "id": "103",
                    "required_fields": [
                        {
                            "label": {
                                "en": "Amount (AED)",
                                "ar": "المبلغ (درهم)"
                            },
                            "name": "amount",
                            "placeholder": {
                                "en": "0.00",
                                "ar": "0.00"
                            },
                            "type": "number",
                            "validation": "",
                            "max_length": 0,
                            "validation_error_message":  {
                                "en": "Amount is required",
                                "ar": "المبلغ مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Bank Account Number",
                                "ar": "رقم الحساب المصرفي"
                            },
                            "name": "bank_account_number",
                            "placeholder": null,
                            "type": "text",
                            "validation": "^[A-Za-z0-9 ]{1,64}${'$'}",
                            "max_length": 64,
                            "validation_error_message":  {
                                "en": "Bank account number is required",
                                "ar": "رقم الحساب البنكي مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Date of Birth (YYYY-MM-DD)",
                                "ar": "سنة-شهر- تاريخ الميالد (يوم)"
                            },
                            "name": "date_of_birth",
                            "placeholder": {
                                "en": "YYYY-MM-DD",
                                "ar": "YYYY-MM-DD"
                            },
                            "type": "text",
                            "validation": "^(?:19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])${'$'}",
                            "max_length": 0,
                            "validation_error_message":  {
                                "en": "Date of birth is required",
                                "ar": "تاريخ الميلاد مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Gender",
                                "ar": "الجنس"
                            },
                            "name": "gender",
                            "placeholder": null,
                            "type": "option",
                            "options": [
                                {
                                    "label": "Male",
                                    "name": "M"
                                },
                                {
                                    "label": "Female",
                                    "name": "F"
                                }
                            ],
                            "validation": "^[\\s\\S]*",
                            "max_length": 0,
                            "validation_error_message": {
                                "en": "",
                                "ar": ""
                            }
                        }
                    ]
                },
                {
                    "name": "First Bank",
                    "id": "104",
                    "required_fields": [
                        {
                            "label": {
                                "en": "Amount (AED)",
                                "ar": "المبلغ (درهم)"
                            },
                            "name": "amount",
                            "placeholder": {
                                "en": "0.00",
                                "ar": "0.00"
                            },
                            "type": "number",
                            "validation": "",
                            "max_length": 0,
                            "validation_error_message":  {
                                "en": "Amount is required",
                                "ar": "المبلغ مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Bank Account Number",
                                "ar": "رقم الحساب المصرفي"
                            },
                            "name": "bank_account_number",
                            "placeholder": null,
                            "type": "text",
                            "validation": "^[A-Za-z0-9 ]{1,64}${'$'}",
                            "max_length": 64,
                            "validation_error_message":  {
                                "en": "Bank account number is required",
                                "ar": "رقم الحساب البنكي مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Last name",
                                "ar": "اسم العائلة"
                            },
                            "name": "lastname",
                            "placeholder": {
                                "en": "Please enter last name",
                                "ar": "الرجاء إدخال الاسم الأخير"
                            },
                            "type": "text",
                            "validation": "^[\\s\\S]*",
                            "max_length": 250,
                            "validation_error_message":  {
                                "en": "Last name is required",
                                "ar": "الاسم الأخير مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Gender",
                                "ar": "الجنس"
                            },
                            "name": "gender",
                            "placeholder": null,
                            "type": "option",
                            "options": [
                                {
                                    "label": "Male",
                                    "name": "M"
                                },
                                {
                                    "label": "Female",
                                    "name": "F"
                                }
                            ],
                            "validation": "^[\\s\\S]*",
                            "max_length": 0,
                            "validation_error_message": {
                                "en": "",
                                "ar": ""
                            }
                        }
                    ]
                },
                {
                    "name": "United Bank",
                    "id": "105",
                    "required_fields": [
                        {
                            "label": {
                                "en": "Amount (AED)",
                                "ar": "المبلغ (درهم)"
                            },
                            "name": "amount",
                            "placeholder": {
                                "en": "0.00",
                                "ar": "0.00"
                            },
                            "type": "number",
                            "validation": "",
                            "max_length": 0,
                            "validation_error_message": {
                                "en": "Amount is required",
                                "ar": "المبلغ مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Bank Account Number",
                                "ar": "رقم الحساب المصرفي"
                            },
                            "name": "bank_account_number",
                            "placeholder": null,
                            "type": "text",
                            "validation": "^[A-Za-z0-9 ]{1,64}${'$'}",
                            "max_length": 64,
                            "validation_error_message":  {
                                "en": "Bank account number is required",
                                "ar": "رقم الحساب البنكي مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Last name",
                                "ar": "اسم العائلة"
                            },
                            "name": "lastname",
                            "placeholder": {
                                "en": "Please enter last name",
                                "ar": "الرجاء إدخال الاسم الأخير"
                            },
                            "type": "text",
                            "validation": "^[\\s\\S]*",
                            "max_length": 250,
                            "validation_error_message":  {
                                "en": "Last name is required",
                                "ar": "الاسم الأخير مطلوب"
                            }
                        }
                    ]
                }
            ]
        },
        {
            "label": {
                "en": "Wallet Transfer",
                "ar": "Wallet Transfer"
            },
            "name": "wallet_transfer",
            "providers": [
                {
                    "name": "ABC Wallet",
                    "id": "501",
                    "required_fields": [
                        {
                            "label": {
                                "en": "Amount (AED)",
                                "ar": "المبلغ (درهم)"
                            },
                            "name": "amount",
                            "placeholder": {
                                "en": "0.00",
                                "ar": "0.00"
                            },
                            "type": "number",
                            "validation": "",
                            "max_length": 0,
                            "validation_error_message": {
                                "en": "Amount is required",
                                "ar": "المبلغ مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Mobile Number",
                                "ar": "رقم الهاتف المتحرك"
                            },
                            "name": "msisdn",
                            "placeholder": null,
                            "type": "msisdn",
                            "validation": "^\\+?[1-9][0-9]{6,14}${'$'}",
                            "max_length": 14,
                            "validation_error_message": {
                                "en": "Mobile number is required",
                                "ar": "رقم الجوال مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "First name",
                                "ar": "االسم األول"
                            },
                            "name": "firstname",
                            "placeholder": {
                                "en": "Please enter first name",
                                "ar": "الرجاء إدخال الاسم الأول"
                            },
                            "type": "text",
                            "validation": "^[\\s\\S]*",
                            "max_length": 250,
                            "validation_error_message": {
                                "en": "First name is required",
                                "ar": "الاسم الأول مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Last name",
                                "ar": "اسم العائلة"
                            },
                            "name": "lastname",
                            "placeholder": {
                                "en": "Please enter last name",
                                "ar": "الرجاء إدخال الاسم الأخير"
                            },
                            "type": "text",
                            "validation": "^[\\s\\S]*",
                            "max_length": 250,
                            "validation_error_message": {
                                "en": "Last name is required",
                                "ar": "الاسم الأخير مطلوب"
                            }
                        }
                    ]
                },
                {
                    "name": "Quick Pay",
                    "id": "502",
                    "required_fields": [
                        {
                            "label": {
                                "en": "Amount (AED)",
                                "ar": "المبلغ (درهم)"
                            },
                            "name": "amount",
                            "placeholder": {
                                "en": "0.00",
                                "ar": "0.00"
                            },
                            "type": "number",
                            "validation": "",
                            "max_length": 0,
                            "validation_error_message": {
                                "en": "Amount is required",
                                "ar": "المبلغ مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Mobile Number",
                                "ar": "رقم الهاتف المتحرك"
                            },
                            "name": "msisdn",
                            "placeholder": null,
                            "type": "msisdn",
                            "validation": "^\\+?[1-9][0-9]{6,14}${'$'}",
                            "max_length": 14,
                            "validation_error_message": {
                                "en":  "Mobile number is required",
                                "ar": "رقم الجوال مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Full Name",
                                "ar": "االسم الكامل"
                            },
                            "name": "full_name",
                            "placeholder": {
                                "en": "Enter full name",
                                "ar": "أدخل االسم الكامل"
                            },
                            "type": "text",
                            "validation": "^[\\s\\S]*",
                            "max_length": 250,
                            "validation_error_message": {
                                "en": "Full name is required",
                                "ar": "االسم الكامل مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Gender",
                                "ar": "الجنس"
                            },
                            "name": "gender",
                            "placeholder": null,
                            "type": "option",
                            "options": [
                                {
                                    "label": "Male",
                                    "name": "M"
                                },
                                {
                                    "label": "Female",
                                    "name": "F"
                                }
                            ],
                            "validation": "^[\\s\\S]*",
                            "max_length": 0,
                            "validation_error_message": {
                                "en":  "",
                                "ar":  ""
                            }
                        }
                    ]
                },
                {
                    "name": "Flash Wallet",
                    "id": "503",
                    "required_fields": [
                        {
                            "label": {
                                "en": "Amount (AED)",
                                "ar": "المبلغ (درهم)"
                            },
                            "name": "amount",
                            "placeholder": {
                                "en": "0.00",
                                "ar": "0.00"
                            },
                            "type": "number",
                            "validation": "",
                            "max_length": 0,
                            "validation_error_message": {
                                "en":  "Amount is required",
                                "ar": "المبلغ مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Mobile Number",
                                "ar": "رقم الهاتف المتحرك"
                            },
                            "name": "msisdn",
                            "placeholder": null,
                            "type": "msisdn",
                            "validation": "^\\+?[1-9][0-9]{6,14}${'$'}",
                            "max_length": 14,
                            "validation_error_message": {
                                "en": "Mobile number is required",
                                "ar": "رقم الجوال مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Province State",
                                "ar": "اإلمارة"
                            },
                            "name": "province_state",
                            "placeholder": null,
                            "options": [
                                {
                                    "label": "Abu Dhabi",
                                    "name": "abu_dhabi"
                                },
                                {
                                    "label": "Dubai",
                                    "name": "dubai"
                                },
                                {
                                    "label": "Sharjah",
                                    "name": "sharjah"
                                }
                            ],
                            "type": "option",
                            "validation": "^[\\s\\S]*",
                            "max_length": 0,
                            "validation_error_message": {
                                "en": "",
                                "ar": ""
                            }
                        },
                        {
                            "label": {
                                "en": "Full Name",
                                "ar": "االسم الكامل"
                            },
                            "name": "full_name",
                            "placeholder": {
                                "en": "Enter full name",
                                "ar": "أدخل االسم الكامل"
                            },
                            "type": "text",
                            "validation": "^[\\s\\S]*",
                            "max_length": 250,
                            "validation_error_message": {
                                "en": "Full name is required",
                                "ar": "االسم الكامل مطلوب"
                            }
                        }
                    ]
                },
                {
                    "name": "Smart Pay",
                    "id": "504",
                    "required_fields": [
                        {
                            "label": {
                                "en": "Amount (AED)",
                                "ar": "المبلغ (درهم)"
                            },
                            "name": "amount",
                            "placeholder": {
                                "en": "0.00",
                                "ar": "0.00"
                            },
                            "type": "number",
                            "validation": "",
                            "max_length": 0,
                            "validation_error_message": {
                                "en": "Amount is required",
                                "ar": "المبلغ مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Mobile Number",
                                "ar": "رقم الهاتف المتحرك"
                            },
                            "name": "msisdn",
                            "placeholder": null,
                            "type": "msisdn",
                            "validation": "^\\+?[1-9][0-9]{6,14}${'$'}",
                            "max_length": 14,
                            "validation_error_message": {
                                "en": "Mobile number is required",
                                "ar": "رقم الجوال مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Full Name",
                                "ar": "االسم الكامل"
                            },
                            "name": "full_name",
                            "placeholder": {
                                "en": "Enter full name",
                                "ar": "أدخل االسم الكامل"
                            },
                            "type": "text",
                            "validation": "^[\\s\\S]*",
                            "max_length": 250,
                            "validation_error_message": {
                                "en": "Full name is required",
                                "ar": "االسم الكامل مطلوب"
                            }
                        }
                    ]
                },
                {
                    "name": "Easy Money",
                    "id": "505",
                    "required_fields": [
                        {
                            "label": {
                                "en": "Amount (AED)",
                                "ar": "المبلغ (درهم)"
                            },
                            "name": "amount",
                            "placeholder": {
                                "en": "0.00",
                                "ar": "0.00"
                            },
                            "type": "number",
                            "validation": "",
                            "max_length": 0,
                            "validation_error_message":  {
                                "en": "Amount is required",
                                "ar": "المبلغ مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Mobile Number",
                                "ar": "رقم الهاتف المتحرك"
                            },
                            "name": "msisdn",
                            "placeholder": null,
                            "type": "msisdn",
                            "validation": "^\\+?[1-9][0-9]{6,14}${'$'}",
                            "max_length": 14,
                            "validation_error_message": {
                                "en": "Mobile number is required",
                                "ar": "رقم الجوال مطلوب"
                            }
                        },
                        {
                            "label": {
                                "en": "Date of Birth (YYYY-MM-DD)",
                                "ar": "سنة-شهر-تاريخ الميالد (يوم)"
                            },
                            "name": "date_of_birth",
                            "placeholder": {
                                "en": "YYYY-MM-DD",
                                "ar": "YYYY-MM-DD"
                            },
                            "type": "text",
                            "validation": "^(?:19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])${'$'}",
                            "max_length": 0,
                            "validation_error_message":  {
                                "en": "Date of birth is required",
                                "ar": "تاريخ الميلاد مطلوب"
                            }
                        }
                    ]
                }
            ]
        }
    ]
}

"""

data class Service(
    val label: LocalizedText,
    val name: String,
    val providers: List<Provider>
)

data class Provider(
    val name: String,
    val id: String,
    val required_fields: List<Field>
)

data class Field(
    val name: String,
    val label: LocalizedText,
    val placeholder: LocalizedText?,
    val type: String,
    val options: List<Option>? = null,
    val validation: String?,
    val max_length: Int?,
    val validation_error_message: LocalizedText
)

data class Option(
    val label: Any,
    val name: String
)

data class LocalizedText(
    val en: String,
    val ar: String
)

@Composable
fun SendMoneyScreen(navController: NavController) {
    val gson = remember { Gson() }
    val services: List<Service> = remember {
        val rootObject = gson.fromJson(jsonData, JsonObject::class.java)
        val type = object : TypeToken<List<Service>>() {}.type
        gson.fromJson(rootObject["services"], type)
    }

    var selectedService by remember { mutableStateOf<Service?>(null) }
    var selectedProvider by remember { mutableStateOf<Provider?>(null) }
    val formData = remember { mutableStateMapOf<String, String>() }
    val submittedRequests = remember { mutableStateListOf<Map<String, String>>() }
    var isEnglish by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { isEnglish = !isEnglish }) {
                Text(if (isEnglish) "Switch to Arabic" else "التبديل إلى الإنجليزية")
            }
            Spacer(modifier = Modifier.width(8.dp))

            // View List Button todo pending
            Button(onClick = { navController.navigate("viewList") }) {
                Text(if (isEnglish) "View List" else "عرض القائمة")
            }
        }


        DropdownMenuWithLabel(
            label = if (isEnglish) "Select Service" else "اختر الخدمة",
            options = services,
            selectedOption = selectedService,
            onOptionSelected = { selectedService = it; selectedProvider = null },
            optionText = { if (isEnglish) it.label.en else it.label.ar }
        )


        selectedService?.let { service ->
            DropdownMenuWithLabel(
                label = if (isEnglish) "Select Provider" else "اختر المزود",
                options = service.providers,
                selectedOption = selectedProvider,
                onOptionSelected = { selectedProvider = it },
                optionText = { it.name }
            )
        }


        selectedProvider?.let { provider ->
            provider.required_fields.forEach { field ->
                when (field.type) {
                    "text", "number" -> DynamicTextField(
                        field = field,
                        value = formData[field.name] ?: "",
                        onValueChange = { formData[field.name] = it },
                        isEnglish = isEnglish
                    )
                    "option" -> DynamicDropdown(
                        field = field,
                        value = formData[field.name],
                        onValueChange = { formData[field.name] = it },
                        isEnglish = isEnglish
                    )
                }
            }

            Button(
                onClick = {
                    println("Form Data: $formData")


                    val hasErrors = provider.required_fields.any { field ->
                        val value = formData[field.name] ?: ""


                        if (field.validation != null && field.validation.isNotEmpty()) {
                            !Regex(field.validation).matches(value)
                        } else if (field.max_length != null && value.length > field.max_length) {
                            true
                        } else if (value.isBlank() && field.validation_error_message != null) {
                            true
                        } else {
                            false
                        }
                    }

                    if (!hasErrors) {
                        errorMessage = null
                        submittedRequests.add(formData.toMap())
                        formData.clear()
                        println("Submitted Requests: $submittedRequests")
                    } else {
                        errorMessage = if (isEnglish) "Please fix the errors." else "يرجى تصحيح الأخطاء."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (isEnglish) "Submit" else "إرسال")
            }

        }


        errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }


        if (submittedRequests.isNotEmpty()) {
            Text(
                text = if (isEnglish) "Submitted Requests" else "الطلبات المرسلة",
                style = MaterialTheme.typography.titleMedium
            )
            LazyColumn {
                items(submittedRequests) { request ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            request.forEach { (key, value) ->
                                Text(text = "$key: $value")
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun DynamicTextField(
    field: Field,
    value: String,
    onValueChange: (String) -> Unit,
    isEnglish: Boolean
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(if (isEnglish) field.label.en else field.label.ar) },
        placeholder = { field.placeholder?.let { Text(if (isEnglish) it.en else it.ar) } },
        keyboardOptions = KeyboardOptions(keyboardType = when (field.type) {
            "number" -> KeyboardType.Number
            else -> KeyboardType.Text
        }),
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun DynamicDropdown(
    field: Field,
    value: String?,
    onValueChange: (String) -> Unit,
    isEnglish: Boolean
) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Text(text = if (isEnglish) field.label.en else field.label.ar)
        Box {
            Button(onClick = { expanded = true }) {
                Text(text = value ?: (if (isEnglish) "Select" else "اختر"))
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                field.options?.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(getOptionLabel(option.label, isEnglish)) },
                        onClick = {
                            onValueChange(option.name)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}


fun getOptionLabel(label: Any, isEnglish: Boolean): String {
    return when (label) {
        is LocalizedText -> if (isEnglish) label.en else label.ar
        is String -> label
        else -> ""
    }
}


@Composable
fun <T> DropdownMenuWithLabel(
    label: String,
    options: List<T>,
    selectedOption: T?,
    onOptionSelected: (T) -> Unit,
    optionText: (T) -> String
) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        Box {
            Button(onClick = { expanded = true }) {
                Text(text = selectedOption?.let(optionText) ?: label)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(optionText(option)) },
                        onClick = {
                            onOptionSelected(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}