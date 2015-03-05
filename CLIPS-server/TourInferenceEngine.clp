;;skeleton code: 	the basis for this code: each question posed to the user will assert a fact. 
;;			each asserted fact will generate working goals for places with the appropriate "tag"
;; 			after all questions are asked, the last rule, recommendation, will look for the top 4 cur_goals and sort them.
;;			if alternate destinations(frequent flyer) is enabled, the output will be the 3th and 4th. else 1st and second.
;; 			this is in clips UI form, thus there are questions. for the JAVA ui, there shouldnt be a need for questions in the clips code.
;;	note: actually day/night tag can be included in the tag multislot field, but since it was originally coded like that, i left it alone.

;to Hamsa: you can just press a random key and press enter to skip the field, cos the bind response will not accept RETURN without a prior value.

;3th last rule: check for error
;2nd last rule: grabs all the cur_goal in the system and sorts them in order of CF, then by rank.
;last rule: prints out whatever is sorted in the last rule.


(deftemplate cur_fact (slot fact) (slot cf)(multislot time)(slot budget)(multislot tag))
(deftemplate cur_goal (slot goal) (slot cf)(slot rank)) ;; 
(deftemplate work_goal (slot goal) (slot cf)(multislot tag)) 
(deftemplate recommend_goal (multislot goal) (multislot cf)(multislot rank))
(deftemplate place_code (slot goal))

(deffacts load-facts
;;default cf and goal cf initialized side by side for easier tallying

(cur_fact (fact SAM) (cf 0.5) (time day) (budget 1 ) (tag  Europe education )) (cur_goal (goal SAM) (cf 0.5)(rank 72))
(cur_fact (fact ASM) (cf 0.5) (time day) (budget 2 ) (tag  Europe education )) (cur_goal (goal ASM) (cf 0.5)(rank 77))
(cur_fact (fact ORC) (cf 0.5) (time day) (budget 2 ) (tag christmas Asia group shopping )) (cur_goal (goal ORC) (cf 0.5)(rank 78))
(cur_fact (fact BUG) (cf 0.5) (time day) (budget 1 ) (tag  Asia group shopping food )) (cur_goal (goal BUG) (cf 0.5)(rank 70.5))
(cur_fact (fact MUS) (cf 0.5) (time day night) (budget 1 ) (tag  Asia group shopping )) (cur_goal (goal MUS) (cf 0.5)(rank 65))
(cur_fact (fact SEN) (cf 0.5) (time day night) (budget 3 ) (tag newyear Indian group family couple landmarks )) (cur_goal (goal SEN) (cf 0.5)(rank 84.5))
(cur_fact (fact URA) (cf 0.5) (time day) (budget 1 ) (tag  Indian group couple culture landmarks education )) (cur_goal (goal URA) (cf 0.5)(rank 85.5))
(cur_fact (fact GBB) (cf 0.5) (time day night) (budget 2 ) (tag  Indian group couple nature landmarks )) (cur_goal (goal GBB) (cf 0.5)(rank 92.5))
(cur_fact (fact SGF) (cf 0.5) (time day night) (budget 2 ) (tag  Indian group couple landmarks )) (cur_goal (goal SGF) (cf 0.5)(rank 84))
(cur_fact (fact MER) (cf 0.5) (time day night) (budget 1 ) (tag  Indian group couple landmarks )) (cur_goal (goal MER) (cf 0.5)(rank 76))
(cur_fact (fact ZOO) (cf 0.5) (time day) (budget 2 ) (tag  Indian family student nature )) (cur_goal (goal ZOO) (cf 0.5)(rank 92))
(cur_fact (fact SGB) (cf 0.5) (time day) (budget 1 ) (tag  Indian family nature )) (cur_goal (goal SGB) (cf 0.5)(rank 88))
(cur_fact (fact BOT) (cf 0.5) (time day) (budget 1 ) (tag  Indian family nature )) (cur_goal (goal BOT) (cf 0.5)(rank 94))
(cur_fact (fact STJ) (cf 0.5) (time night) (budget 2 ) (tag  drinking )) (cur_goal (goal STJ) (cf 0.5)(rank 60))
(cur_fact (fact ZOK) (cf 0.5) (time night) (budget 2 ) (tag  drinking )) (cur_goal (goal ZOK) (cf 0.5)(rank 63))
(cur_fact (fact CKQ) (cf 0.5) (time day night) (budget 2 ) (tag  food drinking Europe Asia India)) (cur_goal (goal CKQ) (cf 0.5)(rank 87))
(cur_fact (fact TOA) (cf 0.5) (time day) (budget 1 ) (tag  Europe culture )) (cur_goal (goal TOA) (cf 0.5)(rank 75))
(cur_fact (fact TBR) (cf 0.5) (time day) (budget 1 ) (tag  Europe culture )) (cur_goal (goal TBR) (cf 0.5)(rank 81))
(cur_fact (fact KPG) (cf 0.5) (time day) (budget 1 ) (tag harirayapuasa Europe student culture )) (cur_goal (goal KPG) (cf 0.5)(rank 85))
(cur_fact (fact CHT) (cf 0.5) (time day) (budget 1 ) (tag lunarnewyear Europe student culture food )) (cur_goal (goal CHT) (cf 0.5)(rank 80))
(cur_fact (fact LTI) (cf 0.5) (time day) (budget 1 ) (tag deepavali Europe student culture )) (cur_goal (goal LTI) (cf 0.5)(rank 66))
(cur_fact (fact CGM) (cf 0.5) (time day) (budget 1 ) (tag  Europe student education )) (cur_goal (goal CGM) (cf 0.5)(rank 91))
(cur_fact (fact SCC) (cf 0.5) (time day) (budget 1 ) (tag  student family education )) (cur_goal (goal SCC) (cf 0.5)(rank 73))
(cur_fact (fact WWW) (cf 0.5) (time day) (budget 2 ) (tag  student family )) (cur_goal (goal WWW) (cf 0.5)(rank 68))
(cur_fact (fact LPS) (cf 0.5) (time day night) (budget 1 ) (tag  food )) (cur_goal (goal LPS) (cf 0.5)(rank 70))
(cur_fact (fact ECP) (cf 0.5) (time day) (budget 2 ) (tag  Indian family nature food )) (cur_goal (goal ECP) (cf 0.5)(rank 82))


(recommend_goal (goal a b c d)(cf 0 0 0 0)(rank 99 99 99 99))

	
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; CF combination for multiple conclusions RULES. This portion of the code follows Charles' code.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;combine POSITIVE certainty factors for multiple conclusions
;cf(cf1,cf2) = cf1 + cf2 * (1- cf1)

(defrule combine-positive-cf
  ?f1 <- (cur_goal (goal ?g) (cf ?cf1&:(>= ?cf1 0)))
  ?f2 <- (work_goal (goal ?g) (cf ?cf2&:(>= ?cf2 0)))
  (test (neq ?f1 ?f2)) ; test pointers and not value
  =>
  (retract ?f2)
  (modify ?f1 (cf = ( + ?cf1 ( * ?cf2 (- 1 ?cf1)))))
)

;combine NEGATIVE cf
;cf(cf1,cf2) = cf1 + cf2 * (1 + cf1)

(defrule combine-neg-cf
 (declare (salience -1))
  ?f1 <- (cur_goal (goal ?g) (cf ?cf1&:(< ?cf1 0)))
  ?f2 <- (work_goal (goal ?g) (cf ?cf2&:(< ?cf2 0)))
  (test (neq ?f1 ?f2))
  =>
  (retract ?f2)
  (modify ?f1 (cf =(+ ?cf1 (* ?cf2 (+ 1 ?cf1)))))
)

;combine one POSITIVE and one NEGATIVE
;cf(cf1,cf2) = (cf1 + cf2) / 1 - MIN[abs(cf1),abs(cf2)]

(defrule neg-pos-cf
 (declare (salience -1))
  ?f1 <- (cur_goal (goal ?g) (cf ?cf1))
  ?f2 <- (work_goal (goal ?g) (cf ?cf2))
  (test (neq ?f1 ?f2))
  (test (< (* ?cf1 ?cf2) 0))
  =>
  (retract ?f2)
  (modify ?f1 (cf =(/ (+ ?cf1 ?cf2) (- 1 (min (abs ?cf1) (abs ?cf2))))))
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; BUSINESS RULES (0) SPECIAL OCCASIONS
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; to activate this rule without UI integrated, need to reset the program, assert the following codes, and press run. Once running, cannot assert code already.

(defrule date_input
	(date ?occasion)
	(cur_fact (fact ?place) (cf ?cf-grab) (tag $? ?occasion $?))
=>	(printout t "A Festive Date is selected" crlf)
	(assert (work_goal (goal ?place) (cf (* ?cf-grab 0.7)) (tag occasion)))
)



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; BUSINESS RULES (1) TIME
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;**** Rule 1: Silent Rule (Time)
; this rule will assert the fact for day/night. Note: I added multislot time because some places like MUSTAFA is 24hr, thus mustafa gets day and night tag. 
; so places that are not operating during the time slot is ruled out of the picture.

;(defrule time_input
;	(declare (salience 10))
;=>	(printout t "What Time are you going 1. day//2. night [enter the number only]" crlf) 
;	(bind ?response (read))
;	(switch ?response
;		(case 1 then
;			(assert (time_input day)))
;		(case 2 then
;			(assert (time_input night)))
;		)
;)


;if time is night, can throw away the places that only doesnt open in night
(defrule night_check_remove
	(time_input night)
	(cur_fact (fact ?place) (cf ?cf-grab) (time ~night))
	?f1 <- (cur_goal (goal ?place) )
=>	(retract ?f1)
	(printout t "Have removed " ?place " as a candidate for discussion" crlf)
)


;;if time is day, can throw away places that are not open in day time.
(defrule day_check_remove
	(time_input day)
	(cur_fact (fact ?place) (cf ?cf-grab) (time ~day))
 ?f1 <- (cur_goal (goal ?place) )
=>	(retract ?f1)
	(printout t "Have removed " ?place " as a candidate for discussion"crlf)
)

;outdated code: will only penalize places that are not open.
;;if time is day, can reject the places that only doesnt open in day
;(defrule day_check
;	(time_input day)
;	(cur_fact (fact ?place) (cf ?cf-grab) (time ~day))
;=>	(assert (work_goal (goal ?place) (cf (* ?cf-grab -1)) (tag time)))
;)
;;if time is night, can reject the places that only doesnt open in night
;(defrule night_check
;	(time_input night)
;	(cur_fact (fact ?place) (cf ?cf-grab) (time ~night))
;=>	(assert (work_goal (goal ?place) (cf (* ?cf-grab -1)) (tag time)))
;)
;outdated code


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; BUSINESS RULES (2) COUNTRY
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;which country are you from?
;(defrule country_input
;=>	(printout t crlf "Which country are you from 1. Asia//2. India//3. Europe [enter the number only]") 
;	(bind ?response (read))
;	(printout t crlf)
;	(switch ?response
;		(case 1 then
;			(assert (country Asia)))
;		(case 2 then
;			(assert (country India)))
;		(case 3 then
;			(assert (country Europe)))
;))

;;if activated, the rule looks for cur_facts with "Europe" in the multislot tag fields
(defrule country_Europe
	(country Europe)
	(cur_fact (fact ?place) (cf ?cf-grab) (tag $? Europe $?))
=>	(assert (work_goal (goal ?place) (cf (* ?cf-grab 0.5)) (tag country)))	
)
(defrule country_India
	(country India)
	(cur_fact (fact ?place) (cf ?cf-grab) (tag $? India $?))
=>	(assert (work_goal (goal ?place) (cf (* ?cf-grab 0.5)) (tag country)))	
)

(defrule country_Asia
	(country Asia)
	(cur_fact (fact ?place) (cf ?cf-grab) (tag $? Asia $?))
	(printout t crlf "Ok working") 
=>	(assert (work_goal (goal ?place) (cf (* ?cf-grab 0.5)) (tag country)))	
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; BUSINESS RULES (3) BUDGET
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;a numeric input is needed or defrule budget_impossible will crash doing numeric comparison.
;(defrule budget_input 
;=>	(printout t crlf "How much are you willing to spend per pax? [3//2//1] (3 being highest [a +ve numeric answer is required, garbage will cause program crash]" crlf) 
;	(bind ?response (read))
;	(printout t crlf)
;	(assert (budget ?response))
;)

; if the user keys in a very high budget, expensive places are more preferred than cheap places.

(defrule budget-possible
	(budget ?amount)
	(cur_fact (fact ?place) (cf ?cf-grab) (budget ?howmuch))
=>	(switch ?amount
		(case 3 then
			(if (eq ?howmuch 3) then
			(assert (work_goal (goal ?place)(cf (* ?cf-grab 0.6))(tag budget)))
			else
				(if (eq ?howmuch 2) then
				(assert (work_goal (goal ?place)(cf (* ?cf-grab 0.5))(tag budget)))
				else
					(if (eq ?howmuch 1) then
					(assert (work_goal (goal ?place)(cf (* ?cf-grab 0.4))(tag budget)))
					)
				)
			)
		)
		(case 2 then	; I don't care about places that are more expensive, anyway they will be eliminated by the next rule
			(if (eq ?howmuch 2) then
			(assert (work_goal(goal ?place)(cf (* ?cf-grab 0.6))(tag budget)))
			else
				(if (eq ?howmuch 1) then
				(assert (work_goal(goal ?place)(cf (* ?cf-grab 0.5))(tag budget)))
				)
			)
		)
		(case 1 then	; I don't care about places that are more expensive, anyway they will be eliminated by the next rule
			(if (eq ?howmuch 1) then
			(assert (work_goal(goal ?place)(cf (* ?cf-grab 0.6))(tag budget)))	
			)
		)
	)	
)

;this rule throws away places that is OUT of budget. once cur_goal is thrown away, the working goal is useless.
(defrule budget-impossible
	(budget ?amount)
	(cur_fact (fact ?place) (cf ?cf-grab) (budget ?howmuch))
	(test(< ?amount ?howmuch))
	?f1 <- (cur_goal (goal ?place))
=>	(retract ?f1)
	(printout t ?place " is retracted due to budget constraints" crlf)	
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; BUSINESS RULES (4) COMPANION
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;(defrule companion_input
;=>	(printout t crlf "Are you travelling with anyone? (1. Alone 2. Couple 3. Family 4. Group 5.Student-Tour. Enter the number only.") 
;	(bind ?response (read))
;	(printout t crlf)
;	(switch ?response
;		(case 1 then
;			(assert (companion alone)))
;		(case 2 then
;			(assert (companion couple)))
;		(case 3 then
;			(assert (companion family)))
;		(case 4 then
;			(assert (companion group)))
;		(case 5 then
;			(assert (companion student)))
;))

(defrule companion_check
	(companion ?type)
	(cur_fact (fact ?place) (cf ?cf-grab) (tag $? ?type $?))
=>	(assert (work_goal (goal ?place) (cf (* ?cf-grab 0.5)) (tag companion)))	
)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; BUSINESS RULES (5) ACTIVITY PREF
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;(defrule activity_input
;=>	(printout t "To further refine your choice, what would you prefer: " crlf)
;	(printout t "1. Shopping//2. Culture//3. Nature//4. Drinking//5. Landmarks//6. Food//7. Education. [numeric input only] " crlf) 
;	(bind ?response (read))
;	(printout t crlf)
;	(switch ?response
;		(case 1 then
;			(assert (activity shopping)))
;		(case 2 then
;			(assert (activity culture)))
;		(case 3 then
;			(assert (activity nature)))
;		(case 4 then
;			(assert (activity drinking)))
;		(case 5 then
;			(assert (activity landmarks)))
;		(case 6 then
;			(assert (activity food)))
;		(case 7 then
;			(assert (activity education)))
;))

(defrule activity_check	;the multiplier here is stronger because it should reflect the user's direct preferences.
	(activity ?type)
	(cur_fact (fact ?place)(cf ?cf-grab) (tag $? ?type $?))
=>	(assert (work_goal (goal ?place) (cf (* ?cf-grab 0.9)) (tag activity)))	
)


;*******************************************
;3th last set of rules
;Introduce the error code if ACTIVITY is provided as input.
;Then, if the user has defined an activity, and there is a cur_goal that matches activity, throw away the error code, it is not needed.
;*******************************************

(defrule got_activity
	(activity ?act)
=>	(assert (cur_goal (goal ERR)(cf 1.0)(rank 99)))	;as long as activity is defined, i will need to assert this error code into the system.
)


(defrule error_check
	(declare (salience -5))
	(activity ?act)
	(cur_fact (fact ?place)(tag $? ?act $?))
	(cur_goal (goal ?place))
	?f1 <- (cur_goal (goal ERR))	
=>	(retract ?f1)
	(printout t "There are places suited for your activity!") ;this rule should only be fired once, once any location is found.
)


;*******************************************
;2nd last set of rule
;find the recommended place
;*******************************************


;;this algo will match the current_goal with the destinations in the recommendation list. 
;;if cur_goal is higher or equal to any of the 4 destinations, 
;;it replaces the item and kicks the rest back by 1, dropping the last item

;this rule will get rid of all the outstanding cur_goals floating in the system

(defrule recommend 
	(declare (salience -10))
	?f1 <- (cur_goal (goal ?place) (cf ?cf-grab) (rank ?grab-rank))
	?f2 <- (recommend_goal (goal ?place1 ?place2 ?place3 ?place4) (cf ?cf1 ?cf2 ?cf3 ?cf4) (rank ?rk1 ?rk2 ?rk3 ?rk4))
=>	(printout t ?place " " ?cf-grab " " ?grab-rank crlf)	
	(retract ?f1)
	(if (>	?cf-grab ?cf1) then ;clear winner by cf alone, thus will take 1st place
	(modify ?f2 (cf ?cf-grab ?cf1 ?cf2 ?cf3) (goal ?place ?place1 ?place2 ?place3) (rank ?grab-rank ?rk1 ?rk2 ?rk3))
	else		
		(if (and (eq ?cf-grab ?cf1)(>= ?grab-rank ?rk1)) then              ;if cf is same and newcomer's rank is higher, take 1st place
			(modify ?f2 (cf ?cf-grab ?cf1 ?cf2 ?cf3) (goal ?place ?place1 ?place2 ?place3) (rank ?grab-rank ?rk1 ?rk2 ?rk3))
		else
  		  (if (> ?cf-grab ?cf2) then
		  (modify ?f2 (cf ?cf1 ?cf-grab ?cf2 ?cf3) (goal ?place1 ?place ?place2 ?place3) (rank ?rk1 ?grab-rank ?rk2 ?rk3))
		  else
			(if (and (eq ?cf-grab ?cf2)(>= ?grab-rank ?rk2)) then
			(modify ?f2 (cf ?cf1 ?cf-grab ?cf2 ?cf3) (goal ?place1 ?place ?place2 ?place3) (rank ?rk1 ?grab-rank ?rk2 ?rk3))
			else
		  	  (if (> ?cf-grab ?cf3) then
			  (modify ?f2 (cf ?cf1 ?cf2 ?cf-grab ?cf3) (goal ?place1 ?place2 ?place ?place3) (rank ?rk1 ?rk2 ?grab-rank ?rk3))
			  else
				(if (and (eq ?cf-grab ?cf3)(>= ?grab-rank ?rk3)) then
				(modify ?f2 (cf ?cf1 ?cf2 ?cf-grab ?cf3) (goal ?place1 ?place2 ?place ?place3) (rank ?rk1 ?rk2 ?grab-rank ?rk3))
				else
			 	  (if (> ?cf-grab ?cf4) then
				  (modify ?f2 (cf ?cf1 ?cf2 ?cf3 ?cf-grab) (goal ?place1 ?place2 ?place3 ?place) (rank ?rk1 ?rk2 ?rk3 ?grab-rank))
				  else
					(if (and (eq ?cf-grab ?cf4)(>= ?grab-rank ?rk4)) then
					(modify ?f2 (cf ?cf1 ?cf2 ?cf3 ?cf-grab) (goal ?place1 ?place2 ?place3 ?place) (rank ?rk1 ?rk2 ?rk3 ?grab-rank))
					)	
				  )
				)
			  )
			)
		  )
		)
	) 
)

;*******************************************
;Last set of rule
;Printout the recommended place
;*******************************************


(defrule printout ;will always be last rule to fire.
	(declare (salience -20))
	(recommend_goal (goal ?a ?b ?c ?d)(cf ?a1 ?b1 ?c1 ?d1)(rank ?r1 ?r2 ?r3 ?r4))
=>	(printout t "(" ?a " " ?b " " ?c " " ?d ") (" ?a1 " " ?b1 " " ?c1 " " ?d1 ") (Rank " ?r1 " " ?r2 " " ?r3 " " ?r4 ")"  crlf) 
	(assert (place_code (goal tino)))
)