(ns design-system.combobox.element
  (:require [design-system.button.element     :as button]
            [design-system.input.element      :as input]
            [design-system.list-items.element :as list-items]))

(defn target
  [attrs]
  (button/secondary
   (merge
    {:class         "ds-combobox-target ds-text-value"
     :aria-expanded (str (boolean (:data/open? attrs)))
     :slot/right    design-system.icons/chevron-down}
    (:attrs/target attrs))
   (:content/target attrs)))

(defn search [attrs]
  (input/search
   (merge {:class "ds-combobox-search"}
          (:attrs/search attrs))))

(defn option-not-found [attrs]
  [:span.ds-combobox-empty-options (:attrs/options-empty attrs)
   (:content/options-empty attrs)])

(defn option-preload [attrs]
  (list-items/item
   (merge {:class "ds-preload"}
          (:attrs/option-preload attrs))))

(defn option-item [attrs option]
  (list-items/item
   (merge {:class "ds-combobox-option"}
          (:attrs/option attrs)
          (:attrs/item option))
   (:content/item option)))

(defn options [attrs]
  (list-items/view
   (merge {:class "ds-combobox-list-items"}
          (:attrs/options attrs))
   (cond
     (not-empty (:data/options attrs))
     (for [option (:data/options attrs)]
       (option-item attrs option))

     (:data/loading? attrs)
     (repeat 15 (option-preload attrs))

     :else (option-not-found attrs))))

(defn dropdown [attrs]
  [:div.ds-combobox-dropdown (merge {:class "hidden"} (:attrs/dropdown attrs))
   (search attrs)
   (options attrs)])

(defn view [attrs]
  [:div.ds-combobox (:attrs/combobox attrs)
   (target attrs)
   (dropdown attrs)])


(comment
  (design-system.core/doc #'view)
  (user/update-element-docs #'view))
