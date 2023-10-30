@Users
  Feature: Users

  #GET USERS
    @Positive 
    Scenario Outline: Get current users profile
      Given Get users current profile
      When Send request get users current profile
      Then Status code 200
      And Response body message should be "<message>"
      And Validate JSON Schema "<JSON Schema>"
      Examples:
        | message              | JSON Schema                   |
        | success show profile | users/GetListUsersSchema.json |

  #PUT UPDATE USERS
    @Positive 
    Scenario: Update users profile with valid req. body
      Given Edit current users profile with valid "users/UpdateUsersProfileWithValidReqBody.json"
      When Send request edit current users profile
      Then Status code 200
      And Response body message should be "success update profile"
      And Validate JSON Schema "MessageSchema.json"


    @Negative 
    Scenario Outline:Update users profile with invalid data
      Given Edit current users profile with valid "<reqBody>"
      When Send request edit current users profile
      Then Status code <statusCode>
      And Response body message should be "<message>"
      And Validate JSON Schema "<JSON Schema>"
      Examples:
        | reqBody                                                  | statusCode | message            | JSON Schema                                                        |
        | users/UpdateUsersProfileWithoutValueInBodyRequest.json   | 400        | error bind data    | users/UpdateUsersProfileWithoutValueInBodyRequestJsonSchema.json   |
        | users/UpdateUserProfileWithoutKeyInBodyRequest.json      | 400        | error bind data    | users/UpdateUserProfileWithoutKeyInBodyRequestJsonSchema.json      |
        | users/UpdateUsersProfileWithEmptyValueInBodyRequest.json | 200        | no data was change | users/UpdateUsersProfileWithEmptyValueInBodyRequestJsonSchema.json |

  #SEARCH USERNAME
    @Positive @Negative 
    Scenario Outline: Search user by username
      Given search user by "<username>"
      When Send request search by username
      Then Status code <statusCode>
      And Response body message should be "<message>"
      And Validate JSON Schema "<JSON Schema>"
      Examples:
        | username     | statusCode | JSON Schema                      | message           |
        | test5        | 200        | users/SearchUsersByUsername.json | success find user |
        | notavailable | 404        | MessageSchema.json               | data not found    |

#  EDIT USER PASSWORD
    @Positive
    Scenario Outline: Edit password users reqBody
      Given edit user password with "<reqBody>"
      When Send request edit password users
      Then Status code <statusCode>
      And Response body message should be "<message>"
      And Validate JSON Schema "<JSON Schema>"
      Examples:
        | reqBody                                     | statusCode | message                                                                    | JSON Schema        |
#        | users/EditPasswordWithoutKey.json           | 400        | old password, new password and confirmation password field cannot be empty | MessageSchema.json |
        | users/EditPasswordWithoutValue.json         | 400        | old password, new password and confirmation password field cannot be empty | MessageSchema.json |
        | users/EditPasswordWithEmptyBodyRequest.json | 400        | old password, new password and confirmation password field cannot be empty | MessageSchema.json |
        | users/EditPasswordValidBodyRequest.json     | 200        | success update password                                                    | MessageSchema.json |


      #DELETE USERS
#    @Positive
#    Scenario Outline: Delete users account
#      Given delete user account
#      When Send request delete account
#      Then Status code 200
#      And Response body message should be "<message>"
#      And Validate JSON Schema "<JSON Schema>"
#      Examples:
#        | message                 | JSON Schema        |
#        | succes delete user data | MessageSchema.json |


  #GET USER WITH SPECIFIC ID

    @Positive
    Scenario: Get users with specific id
      Given Get user with specific id "203"
      When Send request get specific users
      Then Status code 200
      And Response body message should be "success show profile"
      And Validate JSON Schema "users/GetUsersWithSpecificId.json"

    @Negative
    Scenario: Get users with specific id isn't exists
      Given Get user with specific id "37193"
      When Send request get specific users
      Then Status code 404
      And Response body message should be "data not found"
      And Validate JSON Schema "MessageSchema.json"

    @Negative
    Scenario: Get users with specific id inputted by alphabet
      Given Get user with specific id "asdjaskld"
      When Send request get specific users
      Then Status code 400
      And Response body message should be "bad request"
      And Validate JSON Schema "MessageSchema.json"

    @Negative
    Scenario: Get users with specific id without token
      Given Get user with specific id without token "203"
      When Send request get specific users
      Then Status code 401
      And Response body message should be "missing or malformed jwt"
      And Validate JSON Schema "MessageSchema.json"

  #GET LIST USER FOLLOWERS

    @Positive
    Scenario: Get list of user followers
      Given Get list of user followers
      When Send request get list of user followers
      Then Status code 200
      And Response body message should be "success show all follower users"
      And Validate JSON Schema "users/GetListOfUsersFollowersSchema.json"

    @Negative
    Scenario: Get list of users followers without token
      Given Get list of user followers without token
      When Send request get list of user followers
      Then Status code 401
      And Response body message should be "missing or malformed jwt"
      And Validate JSON Schema "MessageSchema.json"

  #GET LIST USER FOLLOWING

    @Positive
    Scenario: Get list of user following
      Given Get list of user following
      When Send request get list of user following
      Then Status code 200
      And Response body message should be "success show all following users"
      And Validate JSON Schema "users/GetListUserFollowingSchema.json"

    @Negative
    Scenario: Get list of users following without token
      Given Get list of user following without token
      When Send request get list of user following
      Then Status code 401
      And Response body message should be "missing or malformed jwt"
      And Validate JSON Schema "MessageSchema.json"

  #UPGRADE USERS ACCOUNT

    @Positive
    Scenario: Request upgrade account to admin
      Given Request upgrade account to admin
      When Send request post upgrade account to admin
      Then Status code 200
      And Response body message should be "success send your request to admin"
      And Validate JSON Schema "MessageSchema.json"

    @Negative
    Scenario: Request upgrade account to admin with already verified user
      Given Request upgrade account to admin
      When Send request post upgrade account to admin
      Then Status code 400
      And Response body message should be "your role already VerifiedUser"
      And Validate JSON Schema "MessageSchema.json"