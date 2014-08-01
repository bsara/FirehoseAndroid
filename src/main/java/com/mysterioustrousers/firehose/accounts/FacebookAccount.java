package com.mysterioustrousers.firehose.accounts;



import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.mysterioustrousers.firehose.FacebookPage;



public class FacebookAccount extends CommunicationAccount {

  private String _userId;
  private String _name;

  private HashSet<FacebookPage> _pages;



  public FacebookAccount() {
    super();

    this.setUserId(null);
    this.setName(null);

    _pages = new HashSet<FacebookPage>();
  }



  // region Getters/Setters


  public String getUserId() {
    return _userId;
  }


  public void setUserId(String userId) {
    _userId = userId;
  }


  public String getName() {
    return _name;
  }


  public void setName(String name) {
    _name = name;
  }



  // region FacebookPages


  public Iterator<FacebookPage> getFacebookPagesIterator() {
    return _pages.iterator();
  }


  public boolean addFacebookPages(Collection<FacebookPage> pages) {
    if (pages == null) {
      return false;
    }

    boolean success = true;
    for (FacebookPage page : pages) {
      success = success && this.addFacebookPage(page);
    }
    return success;
  }


  public boolean addFacebookPage(FacebookPage page) {
    if (page == null) {
      return false;
    }

    if (page.getFacebookAccount() != this) {
      return page.setFacebookAccount(this);
    }

    return _pages.add(page);
  }


  public boolean clearFacebookPages() {
    boolean success = true;
    for (FacebookPage page : new HashSet<FacebookPage>(_pages)) {
      success = success && this.removeFacebookPage(page);
    }
    return success;
  }


  public boolean removeFacebookPage(FacebookPage page) {
    if (page == null) {
      return false;
    }

    boolean success = _pages.remove(page);

    if (success && page.getFacebookAccount() == this) {
      return page.setFacebookAccount(null);
    }

    return success;
  }


  // endregion


  // endregion
}