(ns hangman.core-test
  (:require [clojure.test :refer :all]
            [hangman.reveal :refer :all]
            [hangman.core :refer :all]
            [hangman.game :as game]
            [hangman.creator :refer :all]))

(def mock-question
  (question-and-answer "Country where austalians live?" "Australia"))

(def mock-game (build-game mock-question))

(defn game-answered-with-letters
  ([letters]
   (game-answered-with-letters letters mock-game))
  ([letters game]
   (if (not (empty? letters))
     (game-answered-with-letters
      (rest letters) (answer game (first letters)))
     game)))

(deftest should-produce-correct-result
  (let [updated-game
        (game-answered-with-letters '("X" "a" "l" "i" "z"))]
    (is (= '("_" "_" "_" "_" "_" "a" "l" "i" "a")
           (game/hidden-letters updated-game)))
    (is (= 3 (game/number-of-tries updated-game)))
    (is (true? (game/are-there-tries-left? updated-game)))))

(deftest should-win-if-all-letters-are-solved
  (let [updated-game
        (game-answered-with-letters '("A" "u" "s" "t" "r" "a" "l" "i"))]
    (is (= '("A" "u" "s" "t" "r" "a" "l" "i" "a")
           (game/hidden-letters updated-game)))
    (is (= 5 (game/number-of-tries updated-game)))
    (is (true? (game/are-there-tries-left? updated-game)))))

(deftest should-loose-if-all-letters-are-not-solved
  (let [updated-game (game-answered-with-letters '("x" "x" "x" "x" "x"))]
    (is (= '("_" "_" "_" "_" "_" "_" "_" "_" "_")
           (game/hidden-letters updated-game)))
    (is (= 0 (game/number-of-tries updated-game)))
    (is (false? (game/are-there-tries-left? updated-game)))))
