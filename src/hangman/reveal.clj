(ns hangman.reveal
  (:require [hangman.game :as game]))

(defn create-letter [element letter]
  (if (= element letter)
    (str letter)
    "_"))

(defn merge-visible-letters [existing-letter new-revealed-letter]
  (cond
    (not= existing-letter "_") (str existing-letter)
    (not= new-revealed-letter "_") (str new-revealed-letter)
    :else "_"))

(defn get-revealed-letters [game character]
  (map create-letter (game/answer game) (repeat (.charAt character 0))))

(defn reveal-hidden-letters-of [game character]
  (let [list-of-revealed-letters (get-revealed-letters game character)]
    (map merge-visible-letters
         (game/hidden-letters game) list-of-revealed-letters)))

(defn get-game-with-revealed-hidden-character [game character]
  (merge game [:hidden-letters (reveal-hidden-letters-of game character)]))
