# RotateImageView
use:
1, like ImageView
```
<com.ewolf.wolfanim.RotateImageView
        android:id="@+id/riv_show"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

2,addLifecycleObserver(lifecycleOwner) , Anim auto start by lifecycleOwner resume and stop by lifecycleOwner pause.
