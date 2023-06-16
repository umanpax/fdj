package com.titre.services.interfaces

import com.titre.models.*
import com.titre.models.notification.NotificationInfo
import com.titre.models.notification.NotificationResponse
import com.titre.models.user.Token
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by pierre-alexandrevezinet on 20/02/2019.
 *
 */

interface IService {

    //****************************************************************************************//
    //       *****************************Titre*******************************//
    //****************************************************************************************//

    /**
     * App Info
     * @return
     */
    @GET("api/appInfo")
    fun getAppInfo(): Observable<AppInfo>


    /**
     * Retrieve get user
     * @return
     */
    @GET("api/user")
    fun getUserByEmail(@Query("email") email: String): Observable<User>


    /**
     * Retrieve get titres by category
     * @return
     */
    @GET("api/gettitresbycategory")
    fun getTitresByCategory(@Query("categorie") categorie: String): Observable<Titres>

    /**
     * Retrieve get titres
     * @return
     */
    @GET("api/gettitres")
    fun getTitres(): Observable<Titres>

    /**
     * Retrieve get titres by email
     * @return
     */
    @GET("api/gettitresbyemail")
    fun getTitresByEmail(@Query("email_user") email: String): Observable<Titres>


    /**
     * Retrieve get titres to moderate
     * @return
     */
    @GET("api/gettitrestomoderate")
    fun getTitresToModerate(): Observable<Titres>

    /**
     * Create titre to moderatex
     * @return
     */
    @POST("api/createtitre")
    fun createNewTitre(@Body titre: Titre): Observable<String>

    /**
     * Add titre to favorites
     * @return
     */
    @POST("api/addtofavorite")
    fun addToFavorites(@Body favorite: Favorite): Observable<String>

    /**
     * Add titre to favorites
     * @return
     */
    @POST("api/deletefromfavorite")
    fun deleteFromFavorites(@Body favorite: Favorite): Observable<String>

    /**
     * Retrieve count its a titre
     * @return
     */
    @GET("api/countitsatitre")
    fun countItsATitre(): Observable<CountItsATitreArray>


    /**
     * Retrieve count like by titre
     * @return
     */
    @GET("api/countlikesbytitre")
    fun countLikeByTitre(): Observable<CountLikeArray>


    /**
     * Retrieve get its a titres by email
     * @return
     */
    @GET("api/getitsatitresbyemail")
    fun getItsATitresByEmail(@Query("email_user") emailUser: String): Observable<ItsATitreArray>

    /**
     * Its A Titre
     * @return
     */
    @POST("api/itsatitre")
    fun itsATitre(@Body itsATitre: ItsATitre): Observable<String>

    /**
     * Delete from its a titre
     * @return
     */
    @POST("api/deletefromitsatitre")
    fun deleteFromItsAtitre(@Body itsATitre: ItsATitre): Observable<String>



    /**
     * Retrieve get likes by email
     * @return
     */
    @GET("api/getlikesbyemail")
    fun getLikesByEmail(@Query("email_user") emailUser: String): Observable<LikeArray>

    /**
     * Like a titre
     * @return
     */
    @POST("api/like")
    fun like(@Body like: Like): Observable<String>

    /**
     * Delete from like
     * @return
     */
    @POST("api/deletefromlike")
    fun deleteFromLike(@Body like: Like): Observable<String>


    /**
     * Create comment
     * @return
     */
    @POST("api/createcomment")
    fun createComment(@Body comment: PostComment): Observable<String>

    /**
     * Create response to comment
     * @return
     */
    @POST("api/createresponsetocomment")
        fun createResponseToComment(@Body responseToComment: PostResponseToComment): Observable<String>

    /**
     * Delete from comments
     * @return
     */
    @POST("api/deletefromcomment")
    fun deleteFromComments(@Body comment: PostComment): Observable<String>


    /**
     * Retrieve count comments by titre
     * @return
     */
    @GET("api/countcommentsbytitre")
    fun countCommentsByTitre(): Observable<CountCommentArray>

    /**
     * Retrieve get all responses by titre
     * @return
     */
    @GET("api/getallresponsetocommentsbytitre")
    fun getAllResponseToCommentsByTitre(@Query("id_titre") idTitre: Int): Observable<ResponseToCommentArray>


    /**
     * Retrieve get responses by titre
     * @return
     */
    @GET("api/getresponsetocommentsbytitre")
    fun getResponseToCommentsByTitre(@Query("id_titre") idTitre: Int, @Query("id_commentaire") idCommentaire: Int): Observable<ResponseToCommentArray>

    /**
     * Retrieve get comments by titre
     * @return
     */
    @GET("api/getcommentsbytitre")
    fun getCommentsByTitre(@Query("id_titre") idTitre: Int): Observable<CommentArray>


    /**
     * Retrieve get all comments
     * @return
     */
    @GET("api/getallcomments")
    fun getAllComments(): Observable<CommentArray>

    /**
     * Retrieve get categories
     * @return
     */
    @GET("api/getcategories")
    fun getCategories(): Observable<CategoryArray>

    /**
     * Retrieve get user favorites titres
     * @return
     */
    @GET("api/getfavoritesbyemail")
    fun getFavoritesByEmail(@Query("email_user") emailUser: String): Observable<Titres>

    /**
     * Moderate
     * @return
     */
    @POST("api/moderate")
    fun moderateTitre(@Body moderation: Moderation): Observable<String>

    /**
     * Retrieve users
     * @return
     */
    @GET("api/users")
    fun getUsers(): Observable<Users>

    /**
     * Retrieve get user
     * @return
     */
    @GET("api/login")
    fun login(@Query("loginpwd") loginpwd: String, @Query("place") place: String): Observable<Token>

    /**
     * Logout
     * @return
     */
    @GET("api/logout")
    fun logout(@Query("email") email: String): Observable<String>


 /**
     * Register
     * @return
     */
    @POST("api/register")
    fun register(@Body user: User): Observable<String>


    /**
     * Get user profile
     * @return
     */
    @GET("api/getuserprofile")
    fun getUserProfile(@Query("email") email: String): Observable<UserProfile>

    /**
     * Create user profile
     * @return
     */
    @POST("api/createuserprofile")
    fun createUserProfile(@Body userProfile: UserProfile): Observable<UserProfile>

    /**
     * Update user profile
     * @return
     */
    @PUT("api/updateuserprofile")
    fun updateUserProfile(@Body userProfile: UserProfile): Observable<UserProfile>

    /**
     * Contact Us
     * @return
     */
    @POST("api/contactus")
    fun contactUs(@Body message: Message): Observable<String>

    /**
     * Get moderated titres by email
     * @return
     */
    @GET("api/getmoderatedtitresbyemail")
    fun getModeratedTitresByEmail(@Query("email") email: String): Observable<ModerationArray>

    /**
     * Add Device
     * @return
     */
    @POST("api/adddevice")
    fun addDevice(@Body device: DeviceToken): Observable<String>

    /**
     * Delete Device
     * @return
     */
    @POST("api/deletedevice")
    fun deleteDevice(@Body deviceToken: DeviceToken): Observable<String>

    /**
     * Update user profile
     * @return
     */
    @PUT("api/updatedevicestate")
    fun updateDeviceState(@Body deviceToken: DeviceToken): Observable<String>

    /**
     * Get moderated titres by email
     * @return
     */
    @GET("api/getdevicebyemail")
    fun getDeviceByEmail(@Query("email_user") email: String,  @Query("android_device_id") androidDeviceId: String): Observable<DeviceToken>

    /**
     * Send email activation account
     * @return
     */
       @GET("api/sendemailactivationaccount")
    fun sendEmailActivationAccount(@Query(" email_user") email: String,  @Query("username") username: String): Observable<String>

    /**
     * Update user activation account
     * @return
     */
    @PUT("api/updateuseraccountactivation")
    fun updateUserAccountActivation (@Body codeActivation: CodeActivation): Observable<String>


    /**
     * Verify email User
     * @return
     */
    @GET("api/verifyuseremail")
    fun verifyEmailUser(@Query(" email") email: String): Observable<String>


    /**
     * Send Email Password Recovery
     * @return
     */
    @GET("api/sendemailpasswordrecovery")
    fun sendEmailPasswordRecovery(@Query(" email_user") email: String): Observable<String>


    /**
     * Update user password recovery
     * @return
     */
    @PUT("api/updateuserpasswordrecovery")
    fun updateUserPasswordRecovery (@Body codeActivation: CodeActivation): Observable<String>


    /**
     * Update user password recovery
     * @return
     */
    @PUT("api/updateuserpassword")
    fun updateUserPassword (@Body updatePassword: UpdatePassword): Observable<String>

    /**
     * Generate Token Recovery Password
     * @return
     */
    @PUT("api/generatetokenrecoverypassword")
    fun generateTokenRecoveryPassword (@Body email: Email): Observable<TokenRecoveryPassword>


    /**
     * Create Notification Info
     * @return
     */
    @POST("api/createnotificationinfo")
    fun createNotificationInfo(@Body info: NotificationInfo): Observable<String>

}