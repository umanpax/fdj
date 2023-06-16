package com.titre.services.ws

import com.titre.models.*
import com.titre.models.common.ResponseCommentsAndResponsesComment
import com.titre.models.common.ResponseCountItsATitreAndLike
import com.titre.models.common.ResponseUserProfileTitresAndTitresUserAndFavoritesAndCountItsATitreArray
import com.titre.models.notification.NotificationInfo
import com.titre.models.user.Token
import com.titre.services.ServiceGenerator
import com.titre.services.interfaces.IService
import com.titre.utils.ApplicationConstants
import io.reactivex.Observable
import org.koin.core.component.KoinComponent

/**
 * Created by pierre-alexandrevezinet on 20/02/2019.
 *
 */
class  DataManager(private val serviceGenerator: ServiceGenerator) : KoinComponent {

    //****************************************************************************************//
    //*****************************TITRE INTERFACE ROOTS IMPLEMENTATION*******************************//
    //****************************************************************************************//

    fun getAppInfo(): Observable<AppInfo> {
        val service = serviceGenerator.createServiceLessToken(IService::class.java)
        return service.getAppInfo()
    }

    fun register(user: User): Observable<String> {
        val service = serviceGenerator.createServiceLessToken(IService::class.java)
        return service.register(user)
    }


    fun getUsers(token: String): Observable<Users> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getUsers()
    }

    fun getTitres(token: String): Observable<Titres> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getTitres()
    }


    fun getTitresByEmail(email: String, token: String): Observable<Titres> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getTitresByEmail(email)
    }


    fun getTitresByCategorie(category: String, token: String): Observable<Titres> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getTitresByCategory(category)
    }

    fun createTitre(titre: Titre, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.createNewTitre(titre)
    }


    fun getTitresToModerate(token: String): Observable<Titres> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getTitresToModerate()
    }

    fun createNewTitre(titre: Titre, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.createNewTitre(titre)
    }


    fun getFavoritesByEmail(emailUser: String, token: String): Observable<Titres> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getFavoritesByEmail(emailUser)
    }

    fun addToFavorites(favorite: Favorite, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.addToFavorites(favorite)
    }

    fun deleteFromFavorites(favorite: Favorite, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.deleteFromFavorites(favorite)
    }

    fun itsATitre(itsATitre: ItsATitre, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.itsATitre(itsATitre)
    }

    fun deleteFromItsATitre(itsATitre: ItsATitre, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.deleteFromItsAtitre(itsATitre)
    }


    fun countItsATitre(token: String): Observable<CountItsATitreArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.countItsATitre()
    }


    fun getItsATitreByEmail(email: String, token: String): Observable<ItsATitreArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return  service.getItsATitresByEmail(email)
    }


    fun moderateTitre(moderation: Moderation, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.moderateTitre(moderation)
    }

    fun login(loginpwd: String, place: String): Observable<Token> {
        val service = serviceGenerator.createServiceLessToken(IService::class.java)
        return service.login(loginpwd, place)
    }


    fun getUserByEmail(token: String, email: String): Observable<User> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getUserByEmail(email)
    }

    fun logout(email: String, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.logout(email)
    }


    fun getUserProfile(token: String, email: String): Observable<UserProfile> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getUserProfile(email)
    }

    fun createUserProfile(userProfile: UserProfile, token: String): Observable<UserProfile> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.createUserProfile(userProfile)
    }

    fun updateUserProfile(userProfile: UserProfile, token: String): Observable<UserProfile> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.updateUserProfile(userProfile)
    }


    fun like(like: Like, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.like(like)
    }

    fun deleteFromLike(like: Like, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.deleteFromLike(like)
    }


    fun countLike(token: String): Observable<CountLikeArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.countLikeByTitre()
    }


    fun getLikeByEmail(email: String, token: String): Observable<LikeArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getLikesByEmail(email)
    }


    fun createComment(comment: PostComment, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.createComment(comment)
    }


    fun deleteFromComments(comment: PostComment, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.deleteFromComments(comment)
    }


    fun createResponseToComment(
        responseToComment: PostResponseToComment,
        token: String
    ): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.createResponseToComment(responseToComment)
    }


    fun countCommentsByTitre(token: String): Observable<CountCommentArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.countCommentsByTitre()
    }

    fun getCommentsByTitre(idTitre: Int, token: String): Observable<CommentArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getCommentsByTitre(idTitre)
    }


    fun getAllResponseToCommentsByTitre(idTitre: Int, token: String): Observable<ResponseToCommentArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getAllResponseToCommentsByTitre(idTitre)
    }

    fun getResponseToCommentsByTitre(idTitre: Int, idCommentaire: Int, token: String): Observable<ResponseToCommentArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getResponseToCommentsByTitre(idTitre, idCommentaire)
    }

    fun getAllComments(token: String): Observable<CommentArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getAllComments()
    }


    fun getCategories(token: String): Observable<CategoryArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getCategories()
    }


    fun countLikesByTitre(token: String): Observable<CountLikeArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.countLikeByTitre()
    }


    fun countItsATitreByTitre(token: String): Observable<CountItsATitreArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.countItsATitre()
    }


    fun contactUs(message: Message, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.contactUs(message)
    }

    fun getModeratedTitresByEmail(email: String, token: String): Observable<ModerationArray> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getModeratedTitresByEmail(email)
    }

    fun addDevice(device: DeviceToken, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.addDevice(device)
    }

    fun deleteDevice(device: DeviceToken, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.deleteDevice(device)
    }


    fun updateDeviceState(device: DeviceToken, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.updateDeviceState(device)
    }

    fun getDeviceByEmail(
        email: String,
        androidDeviceId: String,
        token: String
    ): Observable<DeviceToken> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.getDeviceByEmail(email, androidDeviceId)
    }


    fun sendEmailActivationAccount(
        email: String,
        username : String,
        token: String
    ): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.sendEmailActivationAccount(email, username)
    }


    fun updateUserAccountActivation(
        codeActivation: CodeActivation,
        token: String
    ): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.updateUserAccountActivation(codeActivation)
    }


    fun verifyUserEmail(
        email: String
    ): Observable<String> {
        val service = serviceGenerator.createServiceLessToken(IService::class.java)
        return service.verifyEmailUser(email)
    }


    fun sendEmailPasswordRecovery(
        email: String,
        token: String
    ): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.sendEmailPasswordRecovery(email)
    }


    fun generateTokenRecoveryPassword(
        email: Email,
    ): Observable<TokenRecoveryPassword> {
        val service = serviceGenerator.createServiceLessToken(IService::class.java)
        return service.generateTokenRecoveryPassword(email)
    }


    fun updateUserPasswordRecovery(
        codeActivation: CodeActivation,
        token: String
    ): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.updateUserPasswordRecovery(codeActivation)
    }

    fun updateUserPassword(
        updatePassword: UpdatePassword,
        token: String
    ): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.updateUserPassword(updatePassword)
    }


    fun createNotificationInfo(notificationInfo: NotificationInfo, token: String): Observable<String> {
        val service = serviceGenerator.createService(IService::class.java, token)
        return service.createNotificationInfo(notificationInfo)
    }


    fun getCountLikeAnCountItsATitre(token: String): Observable<ResponseCountItsATitreAndLike> {
        return Observable.zip(
            countItsATitreByTitre(token),
            countLikesByTitre(token)
        )
        { countLike, countItsATitres -> ResponseCountItsATitreAndLike(countLike, countItsATitres) }

    }


    fun getUserProfileAndTitresAndUserTitresAndUserFavoritesAndItsATitres(
        email: String,
        token: String
    ): Observable<ResponseUserProfileTitresAndTitresUserAndFavoritesAndCountItsATitreArray> {
        return Observable.zip(
            getUserByEmail(token, email),
            getTitres(token),
            getTitresByEmail(email, token),
            getFavoritesByEmail(email, token),
            countItsATitre(token),
            getItsATitreByEmail(email, token),
            countLike(token),
            getLikeByEmail(email, token),
            getAllComments(token)


        ) { user, titres, titresUser, userFavorites, countItsATitreArray, itsATitreArray, countLikeArray, likeArray, commentArray ->
            ResponseUserProfileTitresAndTitresUserAndFavoritesAndCountItsATitreArray(
                user,
                titres,
                titresUser,
                userFavorites,
                countItsATitreArray,
                itsATitreArray,
                countLikeArray,
                likeArray,
                commentArray
            )
        }
    }

    fun getCommentsAndResponsesByTitre(idTitre : Int, token: String): Observable<ResponseCommentsAndResponsesComment> {
        return Observable.zip(
            getCommentsByTitre(idTitre, token),
            getAllResponseToCommentsByTitre(idTitre,token)
        )
        { commentsByTitre, allResponsesByComments -> ResponseCommentsAndResponsesComment(commentsByTitre, allResponsesByComments) }

    }

}


