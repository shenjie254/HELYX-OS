/*******************************************************************************
 *  |       o                                                                   |
 *  |    o     o       | HELYX-OS: The Open Source GUI for OpenFOAM             |
 *  |   o   O   o      | Copyright (C) 2012-2016 ENGYS                          |
 *  |    o     o       | http://www.engys.com                                   |
 *  |       o          |                                                        |
 *  |---------------------------------------------------------------------------|
 *  |   License                                                                 |
 *  |   This file is part of HELYX-OS.                                          |
 *  |                                                                           |
 *  |   HELYX-OS is free software; you can redistribute it and/or modify it     |
 *  |   under the terms of the GNU General Public License as published by the   |
 *  |   Free Software Foundation; either version 2 of the License, or (at your  |
 *  |   option) any later version.                                              |
 *  |                                                                           |
 *  |   HELYX-OS is distributed in the hope that it will be useful, but WITHOUT |
 *  |   ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or   |
 *  |   FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License   |
 *  |   for more details.                                                       |
 *  |                                                                           |
 *  |   You should have received a copy of the GNU General Public License       |
 *  |   along with HELYX-OS; if not, write to the Free Software Foundation,     |
 *  |   Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA            |
 *******************************************************************************/

package eu.engys.util.filechooser.authentication.authenticator;

import org.apache.commons.vfs2.UserAuthenticationData;
import org.apache.commons.vfs2.UserAuthenticationData.Type;
import org.slf4j.Logger;

import eu.engys.util.filechooser.authentication.UserAuthenticationDataWrapper;

public class OtrosStaticUserAuthenticator implements OtrosUserAuthenticator {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(OtrosStaticUserAuthenticator.class);

    private final UserAuthenticationDataWrapper userAuthenticationDataWrapper;
    private final UserAuthenticationData userAuthenticationData;

    public OtrosStaticUserAuthenticator(UserAuthenticationData userAuthenticationData) {
        this.userAuthenticationData = userAuthenticationData;
        userAuthenticationDataWrapper = new UserAuthenticationDataWrapper();
    }

    @Override
    public UserAuthenticationData requestAuthentication(Type[] arg0) {
        LOGGER.info("Received request for authentication");
        UserAuthenticationDataWrapper data = new UserAuthenticationDataWrapper();
        for (Type type : arg0) {
            data.setData(type, userAuthenticationData.getData(type));
            userAuthenticationDataWrapper.setData(type, userAuthenticationData.getData(type));
        }
        return data;
    }

    @Override
    public UserAuthenticationDataWrapper getLastUserAuthenticationData() {
        return userAuthenticationDataWrapper;
    }
//
//    @Override
//    public boolean isPasswordSave() {
//        return false;
//    }

}
