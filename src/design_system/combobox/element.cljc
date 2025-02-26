(ns design-system.combobox.element
  (:require [design-system.button.element     :as button]
            [design-system.input.element      :as input]
            [design-system.list-items.element :as list-items]))

(defn target
  [params]
  ;; TODO: Use input
  (button/secondary
   {:content/button (:content/target params)
    :content/right  design-system.icons/chevron-down
    :attrs/button   (merge
                     {:class         "ds-combobox-target ds-text-value"
                      :aria-expanded (str (boolean (:data/open? params)))}
                     (:attrs/target params))}))

(defn search [params]
  (input/search
   (merge {:class "ds-combobox-search"}
          (:attrs/search params))))

(defn option-not-found [params]
  [:span.ds-combobox-empty-options (:attrs/options-empty params)
   (:content/options-empty params)])

(defn option-preload [params]
  (list-items/item
   (merge {:class "ds-preload"}
          (:attrs/option-preload params))))

(defn option-item [params option]
  (list-items/item
   (merge {:class "ds-combobox-option"}
          (:attrs/option params)
          (:attrs/item option))
   (:content/item option)))

(defn options [params]
  (list-items/view
   (merge {:class "ds-combobox-list-items"}
          (:attrs/options params))
   (cond
     (not-empty (:data/options params))
     (for [option (:data/options params)]
       (option-item params option))

     (:data/loading? params)
     (repeat 15 (option-preload params))

     :else (option-not-found params))))

(defn dropdown [params]
  [:div.ds-combobox-dropdown (merge {:class "hidden"} (:attrs/dropdown params))
   (search params)
   (options params)])

(defn view [params]
  [:div.ds-combobox (:attrs/combobox params)
   (target params)
   (dropdown params)])


(comment
  (design-system.core/doc #'view)
  (user/update-element-docs #'view))
