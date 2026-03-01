/*
 * This file is part of WebGoat, an Open Web Application Security Project utility. For details, please see http://www.owasp.org/
 *
 * Copyright (c) 2002 - 2019 Bruce Mayhew
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * Getting Source ==============
 *
 * Source for this application is maintained at https://github.com/WebGoat/WebGoat, a repository for free software projects.
 */

package org.owasp.webgoat.lessons.insecurelogin;

import java.util.regex.Pattern;

import org.owasp.webgoat.container.assignments.AssignmentEndpoint;
import org.owasp.webgoat.container.assignments.AttackResult;
import org.owasp.webgoat.webwolf.user.UserService;
import org.owasp.webgoat.webwolf.user.WebGoatUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class InsecureLoginTask extends AssignmentEndpoint {

    private final BCryptPasswordEncoder bCryptoPasswordEncoder;

    private final UserService userService;

    InsecureLoginTask(UserService userService, BCryptPasswordEncoder bCryptoPasswordEncoder) {
        this.userService = userService;
        this.bCryptoPasswordEncoder = bCryptoPasswordEncoder;
    }

  @PostMapping("/InsecureLogin/task")
  @ResponseBody
  public AttackResult completed(@RequestParam String username, @RequestParam String password) {
    isValidUsername(username);
    isValidPassword(password);
    String hashedPassword = bCryptoPasswordEncoder.encode(password);
    WebGoatUser user = userService.loadUserByUsernameLogin(username);
    if(user != null && bCryptoPasswordEncoder.matches(hashedPassword,user.getPassword()) ){
      return success(this).build();
    }else{        
      return failed(this).build();
    }
  }
  
  private void isValidUsername(String username) {
    if (username == null || Pattern.compile("^[a-zA-Z0-9\\s]+$").matcher(username).matches()) { 
      throw new IllegalArgumentException("Incorrect password or username"); 
    } 
  }

  private void isValidPassword(String password) {
    if (password == null || Pattern.compile("^[a-zA-Z0-9!@#$%^&*()_+-=\\[\\]{}\\|;:'\",\\.<>?/\\s]+$").matcher(password).matches()) { 
      throw new IllegalArgumentException("Incorrect password or username"); 
    } 
  }

  @PostMapping("/InsecureLogin/login")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void login() {
    // only need to exists as the JS needs to call an existing endpoint
  }
}
