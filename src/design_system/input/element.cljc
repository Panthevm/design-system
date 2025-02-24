(ns design-system.input.element
  (:require [design-system.icons :as icons]))

(defn view [attrs]
  [:div.ds-input-wrapper
   (when-let [slot-left (:slot/left attrs)]
     [:span.ds-input-left slot-left])
   [:input.ds-input (dissoc attrs :slot/left)]])

(defn search [attrs]
  (view (assoc attrs :slot/left icons/search)))
