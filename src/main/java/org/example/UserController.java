/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package org.example;

import org.example.domain.User;
import org.example.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{id}", method = { RequestMethod.GET })
    public User get(@PathVariable("id") Long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/size", method = { RequestMethod.GET })
    public int getALL() {
        return userRepository.findAll().size();
    }

    @RequestMapping(value = "/add/{name}", method = { RequestMethod.GET })
    public User post(@PathVariable(" name") String name) {
        return userRepository.save(new User(new Random().nextLong(), name, 30));
    }

    @RequestMapping(value = "/init/{size}", method = { RequestMethod.GET })
    public void init(@PathVariable(" size") Long size) {
        for(Long i =0L;i< size;i++){
            userRepository.save(new User(i, "name"+size, new Random().nextInt()));
        }
    }


    @RequestMapping(value = "/id", method = { RequestMethod.DELETE })
    public void delete(@PathVariable(" id") Long id) {
         userRepository.delete(id);
    }
}
