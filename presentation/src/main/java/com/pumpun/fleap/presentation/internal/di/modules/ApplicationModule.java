/**
 * Copyright (C) 2015 Pumpun Dixital Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pumpun.fleap.presentation.internal.di.modules;

import android.content.Context;
import com.pumpun.fleap.data.cache.UserCache;
import com.pumpun.fleap.data.cache.UserCacheImpl;
import com.pumpun.fleap.data.executor.JobExecutor;
import com.pumpun.fleap.data.repository.UserDataRepository;
import com.pumpun.fleap.domain.executor.PostExecutionThread;
import com.pumpun.fleap.domain.executor.ThreadExecutor;
import com.pumpun.fleap.domain.repository.UserRepository;
import com.pumpun.fleap.presentation.AndroidApplication;
import com.pumpun.fleap.presentation.UIThread;
import com.pumpun.fleap.presentation.navigation.Navigator;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton UserCache provideUserCache(UserCacheImpl userCache) {
    return userCache;
  }

  @Provides @Singleton UserRepository provideUserRepository(UserDataRepository userDataRepository) {
    return userDataRepository;
  }
}
