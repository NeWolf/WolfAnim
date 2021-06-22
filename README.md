# RotateImageView
##Use:
1,
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

2,
```
dependencies {
	        implementation 'com.github.NeWolf:WolfAnimDemo:Tag'
	}
```
3, like ImageView
```
<com.ewolf.wolfanim.RotateImageView
        android:id="@+id/riv_show"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

4,addLifecycleObserver(lifecycleOwner) 
Anim auto start by lifecycleOwner resume and stop by lifecycleOwner pause.
