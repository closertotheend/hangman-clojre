(defproject hangman "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot hangman.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :user    {:plugins [; lein ancient - search for outdated dependencies
                                 [lein-ancient "0.6.8"]
                                 ; lein cljfmt fix - format code
                                 [lein-cljfmt "0.3.0"]
                                 ; lein kibit - static code analyzer
                                 [lein-kibit "0.1.2"]
                                 ; lein eastwood - code linter
                                 [jonase/eastwood "0.2.3"]
                                 ; lein bikeshed - code linter
                                 [lein-bikeshed "0.2.0"]
                                 ; lein test-refresh - retest on file save
                                 [com.jakemccrary/lein-test-refresh "0.12.0"]
                                 ; lein cloverage - test coverage/check target folder
                                 [lein-cloverage "1.0.6"]
                                 ; lein annotations - list todos fixmes etc
                                 [lein-annotations "0.1.0"]
                                 ; lein codox - generate doc/check target folder
                                 [lein-codox "0.9.1"]
                                 ; lein vanity - code statistics
                                 [lein-vanity "0.2.0"]
                                 ; lein instant-cheatsheet - localhost:13370
                                 [lein-instant-cheatsheet "2.1.4"]
                                 ; make console colorful
                                 [venantius/ultra "0.4.0"]
                                 ; autoreload in repl on file change
                                 [lein-autoreload "0.1.0"]
                                 ]
                       }})
