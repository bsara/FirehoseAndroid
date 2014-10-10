package com.mysterioustrousers.firehose.accounts;



import java.net.MalformedURLException;
import java.net.URL;

import com.mysterioustrousers.firehose.FHObject;
import com.mysterioustrousers.net.GravatarDefaultImage;
import com.mysterioustrousers.net.GravatarFactory;



public abstract class Account extends FHObject<Integer> {

  private String _username;
  private URL    _avatarURL;



  protected Account() {
    super();

    this.setUsername(null);
    this.setAvatarURL(null);
  }



  // region Getters/Setters



  public String getUsername() {
    return _username;
  }


  public void setUsername(String username) {
    _username = username;
  }


  public URL getAvatarURL() {
    if (_avatarURL != null) {
      return _avatarURL;
    }
    try {
      return GravatarFactory.getInstance().getGravatarURL(this.getUsername(), GravatarDefaultImage.IDENTICON);
    } catch (MalformedURLException e) {
      e.printStackTrace();
      return null;
    }
  }


  public void setAvatarURL(URL avatarURL) {
    _avatarURL = avatarURL;
  }


  // endregion
}