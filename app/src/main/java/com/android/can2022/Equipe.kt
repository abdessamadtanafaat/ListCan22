import android.os.Parcel
import android.os.Parcelable

data class Equipe(
    val pays: String,
    val drapeau: String,
    val groupe: String,
    val coach: String,
    val starPlayer: String,
    val coachImage: String,        // Add coachImage property
    val starPlayerImage: String,   // Add starPlayerImage property
    val lineupImage: String        // Add lineupImage property
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pays)
        parcel.writeString(drapeau)
        parcel.writeString(groupe)
        parcel.writeString(coach)
        parcel.writeString(starPlayer)
        parcel.writeString(coachImage)
        parcel.writeString(starPlayerImage)
        parcel.writeString(lineupImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Equipe> {
        override fun createFromParcel(parcel: Parcel): Equipe {
            return Equipe(parcel)
        }

        override fun newArray(size: Int): Array<Equipe?> {
            return arrayOfNulls(size)
        }
    }
}
