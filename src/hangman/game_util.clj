(ns hangman.game-util)

(def number-of-tries 5)

(defn get-answer [question-and-answer] (get question-and-answer :answer))

(defn get-question [question-and-answer] (get question-and-answer :question))

(defn get-hidden-letters [question-and-answer] (get question-and-answer :hidden-letters))

(defn get-number-of-tries [question-and-answer] (get question-and-answer :number-of-tries-left))

(defn all-hidden-letters-are-revealed? [game] (every? #(not= "_" %) (get-hidden-letters game)))

(defn are-there-tries-left? [game] (not= 0 (get-number-of-tries game)))

(defn answer-contains-character? [answer character] (.contains answer character))