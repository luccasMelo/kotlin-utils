
# KotlinUtils  [![](https://jitpack.io/v/luccasMelo/kotlin-utils.svg)](https://jitpack.io/#luccasMelo/kotlin-utils)

> Library for Android(kotlin/java) to make your development more easy and fast with the main utils 


**Never** waste your time again.
It provides you with the easiest possible implementation of a utilities for your application.
There  is a **UniversalMask, MaskWatcher, MonetaryMask, Generic Adapater and Persistence**

# Setup
## 1. Provide the gradle dependency

### Step one
```gradle
//Add it in your root build.gradle at the end of repositories
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```
### Step two

```gradle
//Add the dependency
	dependencies {
	   implementation 'com.github.luccasMelo:kotlin-utils:0.0.7'
	}

```
### Step three (optional)

```gradle
//Add the GSON dependency if you need a persistence util module
	dependencies {
	   implementation 'com.google.code.gson:gson:2.8.0'
	}

```

## 2. Implement the utils

### UniversalMask

```
//Kotlin implementation
val valueMasked = "12345678912".mask("###.###.###-##")//Result example 123.456.789-12

```

### MaskWatcher

```
//Kotlin implementation
editText.addTextChangedListener(MaskWatcher("###.###.###-##"))

```

### MonetaryMask

```
//Kotlin implementation
val value = "1234"
value.toMoney() //Result example "$ 12,34"
```

### Generic Adapater
Before use this adapter, you need enable a databinding in your project and create a item using that.
Follow this tutorial: (https://medium.com/@jencisov/androids-data-binding-with-kotlin-df94a24ffc0f)

**Create a layout for item**
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="item"
            type="android.databinding.ObservableField"/>
    </data>
    <android.support.constraint.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:id="@+id/textView3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginBottom="8dp"
            android:layout_marginEnd="8dp"
            android:layout_marginStart="8dp"
            android:layout_marginTop="8dp"
            android:text="@{String.valueOf(item)}"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
    </android.support.constraint.ConstraintLayout>
</layout>
```
**Implement the adapter**
```
//Kotlin implementation
public class AdapterImplement(val listString: List<String>): GenericAdapter<List<ObservableField<String>>>(){
    override fun getVarId(): Int {
        return BR.item
    }

    override fun getItemCount(): Int {
        return listString.size
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_adapter
    }

    override fun getObjForPosition(position: Int): Any {
        return ObservableField(listString[position])
    }

    override fun update(objects: List<List<ObservableField<String>>>) {
        //implement
    }

}

```
**Call the implementation**
```
//Kotlin implementation
rcv.adapter = AdapterImplement(listOf("item1","item2"))

```

### Persistence

```
//Kotlin implementation
"String".save(this, "tag")//Save strings our other objects

loadString(this,"tag")//Result example "String". To load objects just call "load()"

```

# Developed By

* Luccas Melo
