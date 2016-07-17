(ns hangman.core
  (:gen-class)
  (:require [hangman.game :as game]
            [hangman.creator :as creator]
            [hangman.reveal :as revealer]
            [hangman.animation :as hangman-animation]
            [clojure.string :refer [blank?]]))

(defn answer [game ^String character]
  (if (game/answer-contains-character? (game/answer game) character)
    (revealer/get-game-with-revealed-hidden-character game character)
    (game/decrement-number-of-tries game)))

(defn ask-and-anwser [game]
  (print "Please type a character to answer... ")
  (println (str (game/number-of-tries game) " tries are left"))
  (let [anwser (read-line)]
    (if (blank? anwser)
      (do (println "Empty char? Try again...") (recur game))
      (answer game anwser))))

(defn perform-game [game]
  (cond
    (game/all-hidden-letters-are-revealed? game) (identity "You won!")
    (game/are-there-tries-left? game)
    (let [updated-game (ask-and-anwser game)]
      (hangman-animation/print-hangman (game/number-of-tries updated-game))
      (println (game/hidden-letters updated-game))
      (recur updated-game))
    :else (println "Game Ended! You lost!")))

(defn start-game [game]
  (println "Hello! Say your name please:")
  (let [name-of-player (read-line)]
    (if (blank? name-of-player)
      (println "Hello, Anonymous one!")
      (println (str "Hello, " name-of-player "!"))))
  (println "Lets start a game with question:" (game/question game))
  (println (game/hidden-letters game))
  (perform-game game))

(defn -main [] (start-game (creator/pick-random-game)))
